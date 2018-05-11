/**
 * 
 */
package com.orbc.syn.session.service.impl;

import static com.orbc.syn.session.constants.AppConstants.ACAP_KEY;
import static com.orbc.syn.session.constants.AppConstants.ACCC_KEY;
import static com.orbc.syn.session.constants.AppConstants.ACCC_VAL;
import static com.orbc.syn.session.constants.AppConstants.ACCT_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLGR_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLID_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLID_VAL;
import static com.orbc.syn.session.constants.AppConstants.CLPASS_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLRTK_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLSE_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLSE_VAL;
import static com.orbc.syn.session.constants.AppConstants.CLTX_KEY;
import static com.orbc.syn.session.constants.AppConstants.CLTX_VAL;
import static com.orbc.syn.session.constants.AppConstants.CLUSR_KEY;
import static com.orbc.syn.session.constants.AppConstants.E_AF;
import static com.orbc.syn.session.constants.AppConstants.E_CCC;
import static com.orbc.syn.session.constants.AppConstants.E_SOF;
import static com.orbc.syn.session.constants.AppConstants.HTTPS;
import static com.orbc.syn.session.constants.AppConstants.SEC_TLS;
import static com.orbc.syn.session.constants.AppConstants.SSO_TOKEN_URL;
import static com.orbc.syn.session.util.Utils.clear;
import static com.orbc.syn.session.util.Utils.isEmpty;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orbc.syn.session.cache.CacheManager;
import com.orbc.syn.session.exception.AuthenticationFailedException;
import com.orbc.syn.session.exception.UserValidationException;
import com.orbc.syn.session.service.ILoginService;
import com.orbc.syn.session.vo.CacheData;
import com.orbc.syn.session.vo.SSOToken;
import com.orbc.syn.session.vo.User;

/**
 * @author ntalari
 *
 */
@Service
public class LoginService implements ILoginService {

	private static final Logger log = LogManager.getLogger(LoginService.class);

	public SSOToken login(User user) {

		log.info("login(User user): starts");

		SSOToken token = getSSOToken(user);
		
		CacheData data=new CacheData();
		data.setToken(token);

		// Adding token to cache
		CacheManager.addToCache(data);

		log.info("login(User user): ends");
		return token;
		
	}

	public SSOToken getSSOToken(User user) {

		log.info("getSSOToken(User user): starts");

		HttpPost post = null;
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = createHTTPSClient();
			post = new HttpPost(SSO_TOKEN_URL);
			post.addHeader(ACCC_KEY, ACCC_VAL);
			post.addHeader(ACAP_KEY, MediaType.APPLICATION_JSON);
			post.addHeader(ACCT_KEY, MediaType.APPLICATION_FORM_URLENCODED);
			List<NameValuePair> params = new ArrayList<>();
			try {
				params.add(new BasicNameValuePair(CLID_KEY, CLID_VAL));
				params.add(new BasicNameValuePair(CLGR_KEY, user.getGrantType()));
				if (CLPASS_KEY.equalsIgnoreCase(user.getGrantType())) {
					params.add(new BasicNameValuePair(CLTX_KEY, CLTX_VAL));
					params.add(new BasicNameValuePair(CLSE_KEY, CLSE_VAL));
					params.add(new BasicNameValuePair(CLUSR_KEY, user.getUserName()));
					params.add(new BasicNameValuePair(CLPASS_KEY, user.getPassword()));
				} else if (CLRTK_KEY.equalsIgnoreCase(user.getGrantType())) {
					params.add(new BasicNameValuePair(CLRTK_KEY, user.getRefreshToken()));
				}
				post.setEntity(new UrlEncodedFormEntity(params));
				response = client.execute(post);
			} finally {
				clear(params);
			}
			
			if(response.getStatusLine().getStatusCode() == 400)
				throw new UserValidationException("invalid username/password");

			if (response.getStatusLine().getStatusCode() != 200)
				throw new Exception(E_SOF + response.getStatusLine().getStatusCode());

			/**
			 * converting JSON (SSO's) response to Java object (SSOResponse)
			 */
			ObjectMapper mapper = new ObjectMapper();
			SSOToken token = mapper.readValue(IOUtils.toString(response.getEntity().getContent()),
					SSOToken.class);
			token.setUserName(user.getUserName());
			
			return token;
		} catch (Exception e) {
			throw new AuthenticationFailedException(E_AF, e);
		} finally {
			try {
				if (!isEmpty(post))
					post.releaseConnection();
				if (!isEmpty(response))
					response.close();
				if (!isEmpty(client))
					client.close();
			} catch (Exception e) {
				throw new RuntimeException(E_CCC, e);
			}
			log.info("getSSOToken(User user): ends");
		}
	}

	private CloseableHttpClient createHTTPSClient() throws NoSuchAlgorithmException, KeyManagementException {
		HttpClientBuilder builder = HttpClientBuilder.create();
		SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(getInsecureSSLContext(SEC_TLS),
				NoopHostnameVerifier.INSTANCE);
		builder.setSSLSocketFactory(sslConnectionFactory);
		HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager(
				RegistryBuilder.<ConnectionSocketFactory>create().register(HTTPS, sslConnectionFactory).build());
		builder.setConnectionManager(ccm);
		return builder.build();
	}

	private SSLContext getInsecureSSLContext(String algorithm) throws KeyManagementException, NoSuchAlgorithmException {
		final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(final java.security.cert.X509Certificate[] arg0, final String arg1)
					throws CertificateException {
			}

			@Override
			public void checkServerTrusted(final java.security.cert.X509Certificate[] arg0, final String arg1)
					throws CertificateException {
			}

		} };
		final SSLContext sslcontext = SSLContext.getInstance(algorithm);
		sslcontext.init(null, trustAllCerts, new java.security.SecureRandom());
		return sslcontext;
	}

	private void refreshCal() {
		SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

		Date date1 = null;
		Date date2 = null;
		try {
			date1 = format.parse("Thu, 03 May 2018 11:08:48 GMT");
			System.out.println(date1);
			System.out.println(date1.getTime() / 60000);

			date2 = format.parse("Thu, 03 May 2018 11:38:48 GMT");
			System.out.println(date2);
			System.out.println(date2.getTime() / 60000);
			
			System.out.println(date1.compareTo(date2)<0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private boolean isTokenExpired(String tokenExpDate) {
		SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

		Date date1 = null;
		Date date2 = null;
		try {
			date1 = new Date();
			System.out.println(date1);
			System.out.println(date1.getTime() / 60000);

			date2 = format.parse(tokenExpDate);
			System.out.println(date2);
			System.out.println(date2.getTime() / 60000);
			
			System.out.println(date1.compareTo(date2)<0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1.compareTo(date2)<0;

	}
	
	/*public static void main(String[] args) {
		
		LoginService ls=new LoginService();
		//ls.refreshCal();
		ls.isTokenExpired("Fri, 04 May 2018 14:02:05 IST");
	}*/

}

/**
 * 
 */
package com.orbcomm.session.service;

import static com.orbcomm.session.constants.AppConstant.ACAP_KEY;
import static com.orbcomm.session.constants.AppConstant.ACCC_KEY;
import static com.orbcomm.session.constants.AppConstant.ACCC_VAL;
import static com.orbcomm.session.constants.AppConstant.ACCT_KEY;
import static com.orbcomm.session.constants.AppConstant.CLGR_KEY;
import static com.orbcomm.session.constants.AppConstant.CLID_KEY;
import static com.orbcomm.session.constants.AppConstant.CLID_VAL;
import static com.orbcomm.session.constants.AppConstant.CLPASS_KEY;
import static com.orbcomm.session.constants.AppConstant.CLRTK_KEY;
import static com.orbcomm.session.constants.AppConstant.CLSE_KEY;
import static com.orbcomm.session.constants.AppConstant.CLSE_VAL;
import static com.orbcomm.session.constants.AppConstant.CLTX_KEY;
import static com.orbcomm.session.constants.AppConstant.CLTX_VAL;
import static com.orbcomm.session.constants.AppConstant.CLUSR_KEY;
import static com.orbcomm.session.constants.AppConstant.E_AF;
import static com.orbcomm.session.constants.AppConstant.E_CCC;
import static com.orbcomm.session.constants.AppConstant.E_SOF;
import static com.orbcomm.session.constants.AppConstant.HTTPS;
import static com.orbcomm.session.constants.AppConstant.SEC_TLS;
import static com.orbcomm.session.constants.AppConstant.SSO_TOKEN_URL;
import static com.orbcomm.session.util.Util.clear;
import static com.orbcomm.session.util.Util.isEmpty;

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
import com.orbcomm.session.exception.AuthenticationFailedException;
import com.orbcomm.session.vo.SSOResponse;
import com.orbcomm.session.vo.User;
import com.orbcomm.sesssion.cache.TokenManager;

/**
 * @author ntalari
 *
 */
@Service
public class LoginService implements ILoginService {

	private static final Logger log = LogManager.getLogger(LoginService.class);
	
    public SSOResponse login(User user) {
		
		log.info("login(User user): starts");
		
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
                } else if(CLRTK_KEY.equalsIgnoreCase(user.getGrantType())) {
                    params.add(new BasicNameValuePair(CLRTK_KEY, user.getRefreshToken()));  
                }
                post.setEntity(new UrlEncodedFormEntity(params));
                response = client.execute(post);
            } finally {
                clear(params);
            }

            if (response.getStatusLine().getStatusCode() != 200) 
                throw new Exception(E_SOF+ response.getStatusLine().getStatusCode());
            
            /**
             * converting JSON (SSO's) response to Java object (SSOResponse)
             */
            ObjectMapper mapper = new ObjectMapper();
            SSOResponse ssoResp = mapper.readValue(IOUtils.toString(response.getEntity().getContent()), SSOResponse.class);
            
            log.info("issued : "+ssoResp.getIssued());
            log.info("expiry : "+ssoResp.getExpires());
            
            //Adding token to cache
            TokenManager.addToken(ssoResp);
            
            return ssoResp;
        } catch (Exception e) {
            throw new AuthenticationFailedException(E_AF, e);
        } finally {
            try {
                if(!isEmpty(post)) post.releaseConnection();
                if(!isEmpty(response)) response.close();
                if(!isEmpty(client)) client.close();
            } catch (Exception e) {
                throw new RuntimeException(E_CCC,e);
            }  
            log.info("login(User user): ends");
        }
    }
	
	private CloseableHttpClient createHTTPSClient() throws NoSuchAlgorithmException, KeyManagementException {   
        HttpClientBuilder builder = HttpClientBuilder.create();
        SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(
            getInsecureSSLContext(SEC_TLS), NoopHostnameVerifier.INSTANCE);
        builder.setSSLSocketFactory(sslConnectionFactory);
        HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTPS, sslConnectionFactory).build());
        builder.setConnectionManager(ccm);
        return builder.build();
    }
	
	private SSLContext getInsecureSSLContext(String algorithm) throws KeyManagementException, NoSuchAlgorithmException {
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    @Override
                    public void checkClientTrusted(
                            final java.security.cert.X509Certificate[] arg0, final String arg1)
                            throws CertificateException {
                    }
                    @Override
                    public void checkServerTrusted(
                            final java.security.cert.X509Certificate[] arg0, final String arg1)
                            throws CertificateException {
                    }

                }
        };
        final SSLContext sslcontext = SSLContext.getInstance(algorithm);
        sslcontext.init(null, trustAllCerts, new java.security.SecureRandom());
        return sslcontext;
    }
	
	private void refreshCal() {
		SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

		Date date = null;
		try {
			date = format.parse("Thu, 03 May 2018 11:08:48 GMT");
			System.out.println(date);
			System.out.println(date.getTime()/60000);

			date = format.parse("Thu, 03 May 2018 11:38:48 GMT");
			System.out.println(date);
			System.out.println(date.getTime()/60000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

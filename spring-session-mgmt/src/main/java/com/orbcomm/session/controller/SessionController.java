package com.orbcomm.session.controller;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbcomm.session.constants.AppConstant;
import com.orbcomm.session.service.impl.LoginService;
import com.orbcomm.session.service.impl.UserService;
import com.orbcomm.session.vo.ForgotPasswordResponse;
import com.orbcomm.session.vo.LoginResponse;
import com.orbcomm.session.vo.SSOToken;
import com.orbcomm.session.vo.Session;
import com.orbcomm.session.vo.User;
import com.orbcomm.sesssion.cache.TokenManager;

@RestController
/**
 * This class is used for managing the sessions(SSO Token). Like get access token when user logs in first time, 
 * refresh token, remove token upon logout of user. 
 * This class also can able to display the cached tokens based on rest call request.
 * @author ntalari
 *
 */
public class SessionController {
	
	private static final Logger log = LogManager.getLogger(SessionController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse login(@RequestBody User user) {
		Session session = new Session();
		getUserService().validateUser(user);
		SSOToken token = getLoginService().login(user);
		session.setAccessToken(token.getAccessToken());
		session.setExpires(token.getExpires());
		session.setIssued(token.getIssued());
		session.setExpiresIn(token.getExpiresIn());

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResponse("success");
		loginResponse.setData(session);
		loginResponse.setDesc("user logged in successfully");
		return loginResponse;
	}

	@RequestMapping(value = "/refreshtoken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Session refreshToken(@RequestBody Session session) {

		SSOToken token = TokenManager.getToken(session.getAccessToken());
		if (token == null)
			throw new RuntimeException("invalid access token");

		// if (DateUtil.isTokenExpired(token.getExpires())) {

		User user = new User();

		user.setGrantType(AppConstant.CLRTK_KEY);
		user.setRefreshToken(token.getRefreshToken());
		user.setUserName(token.getUserName());

		SSOToken newToken = getLoginService().getSSOToken(user);

		TokenManager.removeToken(token);// removing old token from cache as it got expired
		TokenManager.addToken(newToken);// adding new token to the cache

		// }

		session.setAccessToken(newToken.getAccessToken());
		session.setExpires(newToken.getExpires());
		session.setIssued(newToken.getIssued());
		session.setExpiresIn(newToken.getExpiresIn());

		return session;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void logout(@RequestBody Session session) {

		SSOToken token = TokenManager.getToken(session.getAccessToken());
		if (token == null) {
			log.error("token is not present in cache");
		}else {
			TokenManager.removeToken(token);
			log.info("token has been removed from cache");
		}

	}

	@GetMapping(value = "/tokens", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<SSOToken> getTokens() {
		return TokenManager.tokens.values();
	}
}

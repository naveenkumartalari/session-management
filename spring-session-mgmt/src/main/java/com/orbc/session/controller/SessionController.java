package com.orbc.session.controller;

import java.util.Collection;
import java.util.List;

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

import com.orbc.session.cache.CacheManager;
import com.orbc.session.constants.AppConstants;
import com.orbc.session.response.vo.LoginResponse;
import com.orbc.session.service.impl.LoginService;
import com.orbc.session.service.impl.MenuManagementService;
import com.orbc.session.service.impl.UserService;
import com.orbc.session.vo.CacheData;
import com.orbc.session.vo.Data;
import com.orbc.session.vo.Menu;
import com.orbc.session.vo.SSOToken;
import com.orbc.session.vo.Session;
import com.orbc.session.vo.User;

/**
 * This class is used for managing the sessions(SSO Token). Like get access
 * token when user logs in first time, refresh token, remove token upon logout
 * of user. This class also can able to display the cached tokens based on rest
 * call request.
 * 
 * @author ntalari
 *
 */
@RestController
public class SessionController {

	private static final Logger log = LogManager.getLogger(SessionController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private MenuManagementService menuManagementService;
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @return the menuManagementService
	 */
	public MenuManagementService getMenuManagementService() {
		return menuManagementService;
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse login(@RequestBody User user) {
		
		getUserService().validateUser(user);
		
		//calling SSO server to get the token
		SSOToken token = getLoginService().login(user);
		
		Session session = new Session();
		session.setAccessToken(token.getAccessToken());
		session.setExpires(token.getExpires());
		session.setIssued(token.getIssued());
		session.setExpiresIn(token.getExpiresIn());
		
		//calling Menu Management service to get user menus
		List<Menu> menus= getMenuManagementService().getMenu(user);
		
		// Adding token and menu info to cache
		CacheData cacheData=new CacheData();
		cacheData.setToken(token);
		cacheData.setMenus(menus);
		CacheManager.addToCache(cacheData);
		
		//preparing response object
		Data data=new Data();
		data.setAuthInfo(session);
		data.setMenus(menus);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResponse("success");
		loginResponse.setData(data);
		loginResponse.setDesc("user logged in successfully");
		
		return loginResponse;
	}

	@RequestMapping(value = "/refreshtoken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Session refreshToken(@RequestBody Session session) {

		CacheData data = CacheManager.getFromCache(session.getAccessToken());
		SSOToken token = data.getToken();
				
		if (token == null)
			throw new RuntimeException("invalid access token");

		// if (DateUtil.isTokenExpired(token.getExpires())) {

		User user = new User();

		user.setGrantType(AppConstants.CLRTK_KEY);
		user.setRefreshToken(token.getRefreshToken());
		user.setUserName(token.getUserName());

		//calling SSO server to get new token
		SSOToken newToken = getLoginService().getSSOToken(user);
		
		CacheData newData=new CacheData();
		newData.setMenus(data.getMenus());
		newData.setToken(newToken);
		
		CacheManager.removeFromCache(token.getAccessToken());// removing old token from cache as it got expired
		CacheManager.addToCache(newData);// adding new token to the cache

		// }

		session.setAccessToken(newToken.getAccessToken());
		session.setExpires(newToken.getExpires());
		session.setIssued(newToken.getIssued());
		session.setExpiresIn(newToken.getExpiresIn());

		return session;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void logout(@RequestBody Session session) {

		CacheData data = CacheManager.getFromCache(session.getAccessToken());
		SSOToken token = data.getToken();
		if (token == null) {
			log.error("token is not present in cache");
		} else {
			CacheManager.removeFromCache(session.getAccessToken());
			log.info("token has been removed from cache");
		}

	}

	@GetMapping(value = "/tokens", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<CacheData> getTokens() {
		return CacheManager.cacheData.values();
	}
}

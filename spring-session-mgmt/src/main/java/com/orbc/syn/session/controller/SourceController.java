/**
 * 
 */
package com.orbc.syn.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orbc.syn.session.cache.CacheManager;
import com.orbc.syn.session.constants.AppConstants;
import com.orbc.syn.session.service.impl.LoginService;
import com.orbc.syn.session.util.DateUtil;
import com.orbc.syn.session.vo.CacheData;
import com.orbc.syn.session.vo.SSOToken;
import com.orbc.syn.session.vo.Session;
import com.orbc.syn.session.vo.User;

/**
 * @author ntalari
 *
 */
@RestController
public class SourceController {

	@Autowired
	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	@RequestMapping(value = "/source", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void testMethod(@RequestBody Session session) {
		CacheData data = CacheManager.getFromCache(session.getAccessToken());
		SSOToken token = data.getToken();
		if (token == null)
			;// TO-DO how handle invalid tokens

		if (DateUtil.isTokenExpired(token.getExpires())) {

			User user = new User();

			user.setGrantType(AppConstants.CLRTK_KEY);
			user.setRefreshToken(token.getRefreshToken());
			user.setUserName(token.getUserName());

			SSOToken newToken = getLoginService().getSSOToken(user);

			CacheData newData = new CacheData();
			newData.setMenus(data.getMenus());
			newData.setToken(newToken);

			CacheManager.removeFromCache(token.getAccessToken());// removing old token from cache as it got expired
			CacheManager.addToCache(newData);// adding new token to the cache

		}
	}
}

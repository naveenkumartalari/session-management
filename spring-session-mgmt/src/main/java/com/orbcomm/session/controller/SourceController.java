/**
 * 
 */
package com.orbcomm.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orbcomm.session.constants.AppConstant;
import com.orbcomm.session.service.impl.LoginService;
import com.orbcomm.session.util.DateUtil;
import com.orbcomm.session.vo.SSOToken;
import com.orbcomm.session.vo.Session;
import com.orbcomm.session.vo.User;
import com.orbcomm.sesssion.cache.TokenManager;

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
	public void testMethod(@RequestBody Session session)
	{
		 SSOToken token=TokenManager.getToken(session.getAccessToken());
		 if(token==null);//TO-DO how handle invalid tokens
		 
		 if(DateUtil.isTokenExpired(token.getExpires())) {
			 
			 User user=new User();
			 
			 user.setGrantType(AppConstant.CLRTK_KEY);
			 user.setRefreshToken(token.getRefreshToken());
			 user.setUserName(token.getUserName());
			 
			 SSOToken newToken=getLoginService().getSSOToken(user);
			 
			 TokenManager.removeToken(token);//removing old token from cache as it got expired
			 TokenManager.addToken(newToken);//adding new token to the cache
			 
			 
		 }
	}
}

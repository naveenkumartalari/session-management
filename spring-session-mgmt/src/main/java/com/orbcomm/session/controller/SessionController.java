package com.orbcomm.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orbcomm.session.service.LoginService;
import com.orbcomm.session.service.UserService;
import com.orbcomm.session.vo.ForgotPasswordResponse;
import com.orbcomm.session.vo.LoginResponse;
import com.orbcomm.session.vo.SSOResponse;
import com.orbcomm.session.vo.Session;
import com.orbcomm.session.vo.User;

@RestController
public class SessionController {

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
	public LoginResponse login(@RequestBody User user)
	{
		Session session=new Session();
		//getUserService().validateUser(user);
		SSOResponse response=getLoginService().login(user);
		session.setAccessToken(response.getAccessToken());
		
		LoginResponse loginResponse=new LoginResponse();
		loginResponse.setResponse("success");
		loginResponse.setData(session);
		loginResponse.setDesc("user logged in successfully");
		return loginResponse;
	}
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ForgotPasswordResponse forgotPassword(@RequestBody User user)
	{
		getUserService().validateForgotPwdReq(user);
		ForgotPasswordResponse response=new ForgotPasswordResponse();
		response.setMessage("new password has been sent to "+user.getEmail());
		return response;
	}
}

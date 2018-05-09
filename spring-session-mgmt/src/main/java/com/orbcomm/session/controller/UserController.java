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

import com.orbcomm.session.response.vo.ForgotPasswordResponse;
import com.orbcomm.session.service.impl.UserService;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ForgotPasswordResponse forgotPassword(@RequestBody User user) {
		getUserService().validateForgotPwdReq(user);
		ForgotPasswordResponse response = new ForgotPasswordResponse();
		response.setMessage("new password has been sent to " + user.getEmail());
		return response;
	}

}

/**
 * 
 */
package com.orbcomm.session.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.orbcomm.session.exception.UserValidationException;
import com.orbcomm.session.service.IUserService;
import com.orbcomm.session.util.EmailValidator;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
@Service
public class UserService implements IUserService {

	@Override
	public void validateUser(User user) {

		String username = user.getUserName();
		String password = user.getPassword();

		if("".equals(username))
			throw new UserValidationException("username should not be empty");
		if("".equals(password))
			throw new UserValidationException("password should not be empty");
	}

	@Override
	public void validateForgotPwdReq(User user) {
		String username = user.getUserName();
		String email = user.getEmail();
		
		EmailValidator emailValidator=new EmailValidator();
		
		if("".equals(username))
			throw new UserValidationException("username should not be empty");
		if("".equals(email))
			throw new UserValidationException("email should not be empty");
		if (!emailValidator.validate(email))
			throw new UserValidationException("invalid email");
		
	}

}

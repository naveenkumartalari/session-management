/**
 * 
 */
package com.orbcomm.session.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.orbcomm.session.exception.ValidationException;
import com.orbcomm.session.util.EmailValidator;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
@Service
public class UserService implements IUserService {

	public static Map<String, String> userMap = new HashMap<>();
	static {
		userMap.put("user", "user");
		userMap.put("admin", "admin");
		userMap.put("DTMUser1", "Pa55word");
		userMap.put("DTMUser5", "Pa55word");
	}

	@Override
	public void validateUser(User user) {

		String username = user.getUserName();
		String password = user.getPassword();

		if("".equals(username))
			throw new ValidationException("username should not be empty");
		if("".equals(password))
			throw new ValidationException("password should not be empty");
		if (!userMap.containsKey(username)) 
			throw new ValidationException("invalid username");
		if (!userMap.containsValue(password))
			throw new ValidationException("invalid password");
	}

	@Override
	public void validateForgotPwdReq(User user) {
		String username = user.getUserName();
		String email = user.getEmail();
		
		EmailValidator emailValidator=new EmailValidator();
		
		if("".equals(username))
			throw new ValidationException("username should not be empty");
		if("".equals(email))
			throw new ValidationException("email should not be empty");
		if (!userMap.containsKey(username)) 
			throw new ValidationException("invalid username");
		if (!emailValidator.validate(email))
			throw new ValidationException("invalid email");
		
	}

}

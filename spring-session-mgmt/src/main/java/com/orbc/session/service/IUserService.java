/**
 * 
 */
package com.orbc.session.service;

import com.orbc.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface IUserService {
	
	public void validateUser(User user);
	public void validateForgotPwdReq(User user);

}

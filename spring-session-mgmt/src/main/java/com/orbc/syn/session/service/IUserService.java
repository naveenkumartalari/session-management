/**
 * 
 */
package com.orbc.syn.session.service;

import com.orbc.syn.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface IUserService {
	
	public void validateUser(User user);
	public void validateForgotPwdReq(User user);

}

/**
 * 
 */
package com.orbcomm.session.service;

import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface IUserService {
	
	public void validateUser(User user);
	public void validateForgotPwdReq(User user);

}

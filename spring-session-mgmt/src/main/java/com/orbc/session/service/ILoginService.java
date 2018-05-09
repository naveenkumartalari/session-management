/**
 * 
 */
package com.orbc.session.service;

import com.orbc.session.vo.SSOToken;
import com.orbc.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface ILoginService {
	
	public SSOToken login(User user);

}

/**
 * 
 */
package com.orbcomm.session.service;

import com.orbcomm.session.vo.SSOToken;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface ILoginService {
	
	public SSOToken login(User user);

}

/**
 * 
 */
package com.orbc.syn.session.service;

import com.orbc.syn.session.vo.SSOToken;
import com.orbc.syn.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface ILoginService {
	
	public SSOToken login(User user);

}

/**
 * 
 */
package com.orbcomm.session.service;

import com.orbcomm.session.vo.SSOResponse;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface ILoginService {
	
	public SSOResponse login(User user);

}

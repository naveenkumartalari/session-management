/**
 * 
 */
package com.orbc.syn.session.service;

import java.util.List;

import com.orbc.syn.session.vo.Menu;
import com.orbc.syn.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface IMenuManagementService {
	public List<Menu> getMenu(User user);

}

/**
 * 
 */
package com.orbc.session.service;

import java.util.List;

import com.orbc.session.vo.Menu;
import com.orbc.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface IMenuManagementService {
	public List<Menu> getMenu(User user);

}

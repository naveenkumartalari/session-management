/**
 * 
 */
package com.orbcomm.session.service;

import java.util.List;

import com.orbcomm.session.vo.Menu;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
public interface IMenuManagementService {
	public List<Menu> getMenu(User user);

}

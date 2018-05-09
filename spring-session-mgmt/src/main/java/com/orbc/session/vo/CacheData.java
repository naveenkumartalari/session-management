/**
 * 
 */
package com.orbc.session.vo;

import java.util.List;

/**
 * @author ntalari
 *
 */
public class CacheData {
	
	private SSOToken token;
	private List<Menu> menus;
	
	/**
	 * @return the token
	 */
	public SSOToken getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(SSOToken token) {
		this.token = token;
	}
	/**
	 * @return the menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}
	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}

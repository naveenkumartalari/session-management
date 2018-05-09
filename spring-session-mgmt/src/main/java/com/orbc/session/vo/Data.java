/**
 * 
 */
package com.orbc.session.vo;

import java.util.List;

/**
 * @author ntalari
 *
 */
public class Data {
	
	private Session authInfo;
	private List<Menu> menus;
	
	/**
	 * @return the authInfo
	 */
	public Session getAuthInfo() {
		return authInfo;
	}
	/**
	 * @param authInfo the authInfo to set
	 */
	public void setAuthInfo(Session authInfo) {
		this.authInfo = authInfo;
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

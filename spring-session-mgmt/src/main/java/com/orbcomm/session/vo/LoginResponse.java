/**
 * 
 */
package com.orbcomm.session.vo;

/**
 * @author ntalari
 *
 */
public class LoginResponse {

	private String response = "failure";// make id default to failure in case of exceptions
	private Session data;
	private String desc;

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the data
	 */
	public Session getData() {
		if (data == null)
			data = new Session();
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Session data) {
		this.data = data;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

}

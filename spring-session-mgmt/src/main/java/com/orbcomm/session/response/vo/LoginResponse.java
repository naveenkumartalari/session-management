/**
 * 
 */
package com.orbcomm.session.response.vo;

import com.orbcomm.session.vo.Data;

/**
 * @author ntalari
 *
 */
public class LoginResponse {

	private String response = "failure";// make it default to failure in case of exceptions
	private Data data;
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
	public Data getData() {
		if (data == null)
			data = new Data();
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Data data) {
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

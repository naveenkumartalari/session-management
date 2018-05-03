package com.orbcomm.session.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonRootName("data")
public class Session {

	private String accessToken;

	/**
	 * @return the acces_token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param acces_token
	 *            the acces_token to set
	 */
	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}

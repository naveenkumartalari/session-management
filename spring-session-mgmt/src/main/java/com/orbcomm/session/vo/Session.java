package com.orbcomm.session.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Session {

	private String accessToken;
	private String issued;
	private String expires;
	private int expiresIn;
	
	/**
	 * @return the acces_token
	 */
	@JsonProperty("access_token")
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
	
	
	/**
	 * @return the issued
	 */
	@JsonProperty(".issued")
	public String getIssued() {
		return issued;
	}
	/**
	 * @param issued the issued to set
	 */
	@JsonProperty(".issued")
	public void setIssued(String issued) {
		this.issued = issued;
	}
	/**
	 * @return the expires
	 */
	@JsonProperty(".expires")
	public String getExpires() {
		return expires;
	}
	/**
	 * @param expires the expires to set
	 */
	@JsonProperty(".expires")
	public void setExpires(String expires) {
		this.expires = expires;
	}
	
	/**
	 * @return the expires_in
	 */
	@JsonProperty("expires_in")
	public int getExpiresIn() {
		return expiresIn;
	}
	
	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpiresIn(int expires_in) {
		this.expiresIn = expires_in;
	}

}

/**
 * 
 */
package com.orbc.session.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ntalari
 *
 */
public class SSOToken {
	
	private String accessToken;
	private String tokenType;
	private int expiresIn;
	private String refreshToken;
	private String clientId;
	private String cleartext;
	private String issued;
	private String expires;
	
	private String userName;
	
	/**
	 * @return the acces_token
	 */
	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param acces_token the acces_token to set
	 */
	public void setAccessToken(String acces_token) {
		this.accessToken = acces_token;
	}
	/**
	 * @return the token_type
	 */
	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}
	/**
	 * @param token_type the token_type to set
	 */
	public void setTokenType(String token_type) {
		this.tokenType = token_type;
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
	/**
	 * @return the refresh_token
	 */
	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}
	/**
	 * @param refresh_token the refresh_token to set
	 */
	public void setRefreshToken(String refresh_token) {
		this.refreshToken = refresh_token;
	}
	/**
	 * @return the client_id
	 */
	@JsonProperty("client_id")
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param client_id the client_id to set
	 */
	public void setClientId(String client_id) {
		this.clientId = client_id;
	}
	/**
	 * @return the cleartext
	 */
	public String getCleartext() {
		return cleartext;
	}
	/**
	 * @param cleartext the cleartext to set
	 */
	public void setCleartext(String cleartext) {
		this.cleartext = cleartext;
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
	public void setExpires(String expires) {
		this.expires = expires;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	@JsonProperty("user_name")
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

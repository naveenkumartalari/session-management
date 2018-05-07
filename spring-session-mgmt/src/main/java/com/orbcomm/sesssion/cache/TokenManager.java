/**
 * 
 */
package com.orbcomm.sesssion.cache;

import java.util.HashMap;
import java.util.Map;

import com.orbcomm.session.vo.SSOToken;

/**
 * @author ntalari
 *
 */
public class TokenManager {
	
	public static Map<String, SSOToken> tokens=new HashMap<>();
	
	public static boolean addToken(SSOToken token) {
		 return tokens.put(token.getAccessToken(), token)==null;
	}
	
	public static boolean removeToken(SSOToken token) {
		 return tokens.remove(token.getAccessToken(), token);
	}
	
	public static SSOToken getToken(String accessToken) {
		 return tokens.get(accessToken);
	}

}

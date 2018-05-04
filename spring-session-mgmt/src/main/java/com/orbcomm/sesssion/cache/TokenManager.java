/**
 * 
 */
package com.orbcomm.sesssion.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.orbcomm.session.vo.SSOToken;

/**
 * @author ntalari
 *
 */
public class TokenManager {
	
	public static Map<String, SSOToken> tokens=new ConcurrentHashMap<>();
	
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

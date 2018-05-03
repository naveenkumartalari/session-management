/**
 * 
 */
package com.orbcomm.sesssion.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.orbcomm.session.vo.SSOResponse;

/**
 * @author ntalari
 *
 */
public class TokenManager {
	
	public static Map<String, SSOResponse> tokens=new ConcurrentHashMap<>();
	
	public static boolean addToken(SSOResponse token) {
		 return tokens.put(token.getAccessToken(), token)==null;
	}
	
	public static boolean removeToken(SSOResponse token) {
		 return tokens.remove(token.getAccessToken(), token);
	}

}

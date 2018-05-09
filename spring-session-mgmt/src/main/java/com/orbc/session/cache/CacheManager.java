/**
 * 
 */
package com.orbc.session.cache;

import java.util.HashMap;
import java.util.Map;

import com.orbc.session.vo.CacheData;

/**
 * @author ntalari
 *
 */
public class CacheManager {
	
	public static Map<String, CacheData> cacheData=new HashMap<>();
	
	public static boolean addToCache(CacheData data) {
		 return cacheData.put(data.getToken().getAccessToken(), data)==null;
	}
	
	public static boolean removeFromCache(String accessToken) {
		 return cacheData.remove(accessToken) != null;
	}
	
	public static CacheData getFromCache(String accessToken) {
		 return cacheData.get(accessToken);
	}

}

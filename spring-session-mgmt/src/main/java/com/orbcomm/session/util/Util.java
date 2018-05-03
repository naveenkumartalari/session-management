/**
 * 
 */
package com.orbcomm.session.util;

import java.util.List;
import java.util.Map;

/**
 * @author ntalari
 *
 */
public class Util {
	
	public static boolean isEmpty(Object object) {
        return (null == object);
    }
    
    public static boolean isEmpty(StringBuilder object) {
        return (null == object || object.length() <= 0);
    }

    public static boolean isEmpty(String object) {
        return (null == object || object.trim().length() <= 0);
    }

    public static boolean isEmpty(String[] object) {
        return (null == object || object.length <= 0);
    }
    
    public static void clear(List list) {
        if(!isEmpty(list)) list.clear();
    }
    
    public static void clear(Map map) {
        if(!isEmpty(map)) map.clear();
    }

}

/**
 * 
 */
package com.orbc.syn.session.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ntalari
 *
 */
public class Utils {
	
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
    
    public static void closeResource(Closeable res){
        if(!isEmpty(res)){
            try {
                res.close();
            } catch (IOException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}

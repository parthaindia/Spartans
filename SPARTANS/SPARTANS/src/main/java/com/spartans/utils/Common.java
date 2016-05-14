package com.spartans.utils;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Partha
 */
public class Common {


    public static Map<String, String> getSingleMapValue(Map<String, String[]> map) {

        if ((map == null) || (map.isEmpty())) {
            return null;
        }

        Map<String, String> newMap = new HashMap<String, String>();
        if (map != null && !map.isEmpty()) {
            Set keyset = map.keySet();
            Iterator it = keyset.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (map.get(key) != null && map.get(key).length > 0) {
                    newMap.put(key, map.get(key)[0]);
                }
            }
        }
        return newMap;
    }

    public Object mapToDto(Map<String, String> inputMap, Class c) throws Exception {
        if (inputMap == null) {
            return null;
        }
        Object dtoObject = c.newInstance();
        Method methods[] = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String fieldName = method.getName().replace("set", "");
                method.invoke(dtoObject, inputMap.get(fieldName.toLowerCase()));
            }
        }
        return dtoObject;
    }


}

package com.dakshay.support.helpers;

import java.util.Collection;

/**
 * Created by dakshay on 01/06/2021.
 */
public class CoreUtils {
    public static boolean isBlank(String s){
        return s == null || "".equals(s);
    }

    public static boolean isNotBlank(String s){
        return !isBlank(s);
    }

    public static boolean isEmpty(Collection c){
        return c==null || c.size()==0;
    }

    public static boolean isNotEmpty(Collection c){
        return !isEmpty(c);
    }

}


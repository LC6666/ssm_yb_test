package com.iebm.ssm.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static Boolean isJson(String str){
        try {
            new ObjectMapper().readTree(str);

            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }

    }
}

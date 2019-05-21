package com.zhcw.pay.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * XML转json工具类
 */
public class Xml2Json {
    public static String xml2JsonString(String xml){
        try {
            JSONObject jsonObj = XML.toJSONObject(xml);
            return jsonObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.zhcw.pay.utils.CommUtils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

public class BeanUtils {
    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return false;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if(!f.getName().equals("mp_id")){
                    if (f.get(object) == null && StringUtils.isBlank(f.get(object).toString()) && f.get(object).equals("null")) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}



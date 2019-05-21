package com.zhcw.zfb.api;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PayNotiftApi {
    /*public String notift(HttpServletRequest request){
        InputStream is = null;
        try {
            is = request.getInputStream();//获取输入流
            ArrayList<Byte> arr = new ArrayList<Byte>();
            byte[] buffer = new byte[50];//缓存数组
            int len;
            //读取数据
            while ((len=is.read(buffer))!=-1) {
                for (int i = 0; i < len; i++) {
                    arr.add(buffer[i]);
                }
            }
            byte[] src = new byte[arr.size()];
            for (int i = 0; i < src.length; i++) {
                src[i] = arr.get(i);
            }
            String json = new String(src);
            @SuppressWarnings("unchecked")
            Map<String, Object> map = Context.gson.fromJson(json, HashMap.class);
            System.out.println(map);
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (is != null)
                is.close();
        }
    }*/
}

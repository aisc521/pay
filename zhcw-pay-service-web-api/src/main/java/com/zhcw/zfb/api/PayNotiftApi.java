package com.zhcw.zfb.api;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收异步
 */
@RestController
@RequestMapping("zhcw")
public class PayNotiftApi {
    /**
     * 交易异步通知
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/trade_notify")
    public Map notift(HttpServletRequest request) throws IOException {
        InputStream is = null;
        Map<String, Object> map = new HashMap<>();
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
            Gson gson = new Gson();
            map = gson.fromJson(json, HashMap.class);
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (is != null)
                is.close();
        }
        return map;
    }
}

package com.zhcw.zfb.api;

import com.google.gson.Gson;
import com.zhcw.pay.utils.HttpUtils.RequestUtil;
import com.zhcw.pay.utils.PayUtils.PayNotiftUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
    private Logger logger = LoggerFactory.getLogger(PayNotiftApi.class);
    /**
     * 交易异步通知
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/trade_notify")
    //@GetMapping("/trade_notify")
    public Map payNotift(HttpServletRequest request) throws IOException {
        Map map = PayNotiftUtils.notift(request);
        return map;
    }

    @PostMapping("/trade_notify1")
    //@GetMapping("/trade_notify")
    public Map payNotift1(HttpServletRequest request) throws IOException {
        Map requestMap = RequestUtil.getParameters(request,true);
        logger.info("异步通知消息:===============================" + requestMap.toString());
        return requestMap;
    }
}

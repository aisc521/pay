package com.zhcw.zfb.api;

import com.zhcw.pay.utils.HttpUtils.RequestUtil;
import com.zhcw.pay.utils.PayUtils.PayNotiftUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
     *
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/trade_notify")
    //@GetMapping("/trade_notify")
    public String payNotift(HttpServletRequest request) throws IOException {
        logger.info("异步通知消息:==================start");
        Map map = PayNotiftUtils.notift(request);
        logger.info("异步通知消息:==================end==" + map.toString());
        return "success";
    }

    @GetMapping("/call_back")
    public String call_back(HttpServletRequest request) throws Exception {
        logger.info("call_back:==================start");
        //获取请求参数
        Map requestMap = RequestUtil.getParameters(request,true);
        logger.info("call_back:==================end" + requestMap.toString());
        return "call_back_html=====hello!!!!!!";
    }
}

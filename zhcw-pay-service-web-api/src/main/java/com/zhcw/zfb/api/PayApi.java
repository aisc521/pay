package com.zhcw.zfb.api;

import com.zhcw.pay.utils.HttpUtils.RequestUtil;
import com.zhcw.pay.utils.PayUtils.Client;
import com.zhcw.pay.utils.PayUtils.PayConfig;
import com.zhcw.pay.utils.PayUtils.StaticV;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.zhcw.pay.utils.CommUtils.MapUtils.validateParamMap;

@RestController
@RequestMapping("zhcw")
public class PayApi {
    /**
     * wap h5  支付api
     * @return
     */
    @PostMapping("pay")
    public Map pay(HttpServletRequest request){

        Map resultMap = new HashMap();
        //获取请求参数
        Map requestMap = RequestUtil.getParameters(request,true);
        //请求参数非空验证
        JSONObject entity = validateParamMap(requestMap);
        if(!entity.getBoolean("flag")){
            resultMap.put("code","50000");
            resultMap.put("msg",entity.get("msg").toString());
        }
        PayConfig payConfig=new PayConfig();
        payConfig.initParams(
                StaticV.mch_id,requestMap.get("ds_trade_no").toString(),requestMap.get("pay_fee").toString(),
                requestMap.get("trade_type").toString(), requestMap.get("trade_subject").toString(),
                requestMap.get("trade_memo").toString(),requestMap.get("notify_url").toString(),requestMap.get("callback_url").toString()
        );
        Client client=new Client();
        String data=client.request(payConfig,"/pay/wap");
        resultMap.put("code","20000");
        resultMap.put("msg",data);
        return resultMap;
    }
}

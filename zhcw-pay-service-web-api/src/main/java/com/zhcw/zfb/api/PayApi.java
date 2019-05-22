package com.zhcw.zfb.api;

import com.zhcw.pay.utils.CommUtils.NotEmotyUtils;
import com.zhcw.pay.utils.CommUtils.NumUtils;
import com.zhcw.pay.utils.HttpUtils.RequestUtil;
import com.zhcw.pay.utils.PayUtils.Client;
import com.zhcw.pay.utils.PayUtils.PayConfig;
import com.zhcw.pay.utils.PayUtils.StaticV;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.zhcw.pay.utils.CommUtils.BeanUtils.checkObjAllFieldsIsNull;
import static com.zhcw.pay.utils.CommUtils.MapUtils.validateParamMap;

@RestController
@RequestMapping("zhcw")
public class PayApi {
    private Logger logger = LoggerFactory.getLogger(PayApi.class);

    /**
     * wap h5  支付api  request 请求
     * @return
     */
    @PostMapping("pay")
    public Map pay_request(HttpServletRequest request){
        logger.info("start------pay--------request");
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
        String pay_fee = NumUtils.number(requestMap.get("pay_fee").toString());
        payConfig.initParams(
                StaticV.mp_id,requestMap.get("ds_trade_no").toString(),pay_fee,
                requestMap.get("trade_type").toString(), requestMap.get("trade_subject").toString(),
                requestMap.get("trade_memo").toString(),requestMap.get("notify_url").toString(),requestMap.get("callback_url").toString(),requestMap.get("user_ip").toString()
        );
        Client client=new Client();
        String data=client.request(payConfig,"/pay/wap");
        resultMap.put("code","20000");
        resultMap.put("msg",data);
        logger.info("end------pay--------request");
        return resultMap;
    }

    /**
     * wap h5  支付api  接口 请求
     * @return
     */
    public  static Map pay_interface(PayConfig payConfig) throws Exception {
        //logger.info("start------pay--------request");
        Map resultMap = new HashMap();
        JSONObject jsonObject = NotEmotyUtils.checkPayAllFieldsIsNull(payConfig);
        if(!jsonObject.getBoolean("flag")){
            resultMap.put("code","50000");
            resultMap.put("msg",jsonObject.get("msg"));
            return resultMap;
        }
        String pay_fee = NumUtils.number(payConfig.getPay_fee());
        payConfig.setMp_id(StaticV.mp_id);
        payConfig.setPay_fee(pay_fee);
        Client client=new Client();
        String data=client.request(payConfig,"/pay/wap");
        resultMap.put("code","20000");
        resultMap.put("msg",data);
        //logger.info("start------pay--------end");
        return resultMap;
    }

    public  static void main(String[] args){
        PayConfig payConfig = new PayConfig();
        payConfig.initParams(
               "","1","15.32",
                "AP", "描述",
                "","www.baidu.com","www.baidu.com","192.168.64.201"
        );
        try {
            pay_interface(payConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

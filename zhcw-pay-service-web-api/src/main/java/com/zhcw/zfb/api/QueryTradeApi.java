package com.zhcw.zfb.api;

import com.zhcw.pay.utils.CommUtils.NotEmotyUtils;
import com.zhcw.pay.utils.HttpUtils.RequestUtil;
import com.zhcw.pay.utils.PayUtils.Client;
import com.zhcw.pay.utils.PayUtils.QueryConfig;
import com.zhcw.pay.utils.PayUtils.StaticV;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class QueryTradeApi {
    private Logger logger = LoggerFactory.getLogger(QueryTradeApi.class);

    /**
     * 交易状态查询api  request 请求
     * @return
     */
    @PostMapping("pay_query")
    public Map tradeQuery(HttpServletRequest request){
        logger.info("start------pay_query--------request");
        Map resultMap = new HashMap();
        //获取请求参数
        Map requestMap = RequestUtil.getParameters(request,true);
        //请求参数非空验证
        JSONObject entity = validateParamMap(requestMap);
        if(!entity.getBoolean("flag")){
            resultMap.put("code","50000");
            resultMap.put("msg",entity.get("msg").toString());
            return requestMap;
        }
        QueryConfig queryConfig=new QueryConfig();
        queryConfig.initParams(StaticV.mp_id,"",requestMap.get("ds_trade_no").toString(),"");
        Client client = new Client();
        String data = client.request(queryConfig,"/pay/tradequery");
        logger.info("start------pay_query--------result_info---"+data);
        resultMap.put("code","20000");
        resultMap.put("msg",data);
        logger.info("end------pay_query--------request");
        return resultMap;
    }

    /**
     * 交易状态查询api  接口 请求
     * @return
     */
    public static Map tradeQuery_interface(QueryConfig queryConfig) throws Exception {
        //logger.info("start------pay_query--------request");
        Map resultMap = new HashMap();
        //获取请求参数
        JSONObject jsonObject = NotEmotyUtils.checkPayQueryAllFieldsIsNull(queryConfig);
        if(!jsonObject.getBoolean("flag")){
            resultMap.put("code","50000");
            resultMap.put("msg",jsonObject.get("msg"));
            return resultMap;
        }
        queryConfig.setMp_id(StaticV.mp_id);
        Client client = new Client();
        String data = client.request(queryConfig,"/pay/tradequery");
        //logger.info("start------pay_query--------result_info---"+data);
        resultMap.put("code","20000");
        resultMap.put("msg",data);
        //logger.info("end------pay_query--------request");
        return resultMap;
    }

//    public static void main(String[] args){
//        QueryConfig payConfig = new QueryConfig();
//        payConfig.initParams(
//                "","","2",
//                ""
//        );
//        try {
//            tradeQuery_interface(payConfig);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

package com.zhcw.pay.utils.CommUtils;

import com.zhcw.pay.utils.PayUtils.PayConfig;
import com.zhcw.pay.utils.PayUtils.QueryConfig;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class NotEmotyUtils {
    public static JSONObject checkPayAllFieldsIsNull(PayConfig payConfig)throws Exception{
        JSONObject notEmpty = new JSONObject();
        boolean flag = true;
        String msg ="";
        if(StringUtils.isEmpty(payConfig.getDs_trade_no())){
            msg += "Ds_trade_no不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getPay_fee())){
            msg += "Pay_fee不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getTrade_type())){
            msg += "Trade_type不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getUser_ip())){
            msg += "User_ip不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getTrade_subject())){
            msg += "Trade_subject不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getTrade_memo())){
            msg += "Trade_memo不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getNotify_url())){
            msg += "Notify_url不能为空==";
            flag = false;
        }
        if(StringUtils.isEmpty(payConfig.getCallback_url())){
            msg += "Callback_url不能为空==";
            flag = false;
        }
        notEmpty.put("flag",flag);
        notEmpty.put("msg",msg);
        return notEmpty;
    }
    public static JSONObject checkPayQueryAllFieldsIsNull(QueryConfig queryConfig)throws Exception{
        JSONObject notEmpty = new JSONObject();
        boolean flag = true;
        String msg ="";
        if(StringUtils.isEmpty(queryConfig.getDs_trade_no())){
            msg += "Ds_trade_no不能为空==";
            flag = false;
        }
        notEmpty.put("flag",flag);
        notEmpty.put("msg",msg);
        return notEmpty;
    }
}

package com.zhcw.zfb.api;

import com.zhcw.pay.utils.PayUtils.Client;
import com.zhcw.pay.utils.PayUtils.ReFundConfig;

public class RefundApi {

    public String refund(){
        ReFundConfig refundConfig=new ReFundConfig();
        refundConfig.initParams("MC0000000000000001","AA0702000240879559","");
        Client client=new Client();
        String data=client.request(refundConfig,"/pay/refund");
        return data;
    }
}

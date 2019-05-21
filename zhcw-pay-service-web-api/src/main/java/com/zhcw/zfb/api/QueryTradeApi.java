package com.zhcw.zfb.api;

import com.zhcw.pay.utils.PayUtils.Client;
import com.zhcw.pay.utils.PayUtils.QueryConfig;

public class QueryTradeApi {

    /**
     * 交易状态查询api
     * @return
     */
    public String tradeQuery(){
        QueryConfig queryConfig=new QueryConfig();
        queryConfig.initParams("MC0000000000000001","AA0702000240879559","","");
        Client client=new Client();
        String data=client.request(queryConfig,"/pay/tradequery");
        return data;
    }
}

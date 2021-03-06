package com.zhcw.pay.utils.PayUtils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//查询相关参数
@Data
@ToString
@RequiredArgsConstructor
public class QueryConfig extends Config{

    public String mp_id;
    public String trade_no;
    public String ds_trade_no;
    public String tp_trade_no;

    public void initParams(String mp_id,String trade_no,String ds_trade_no,String tp_trade_no){
        this.mp_id=mp_id;
        if(trade_no!=""){
            this.trade_no=trade_no;
        }else if(ds_trade_no!=""){
            this.ds_trade_no=ds_trade_no;
        }else if(tp_trade_no!=""){
            this.tp_trade_no=tp_trade_no;
        }
    }
}

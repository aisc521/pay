package com.zhcw.pay.utils.PayUtils;
//退款相关参数
public class ReFundConfig extends Config {
    public String mch_id;
    public String trade_no;
    public String ds_trade_no;

    public void initParams(String mch_id,String trade_no,String ds_trade_no){
        this.mch_id=mch_id;
        if(trade_no!=""){
            this.trade_no=trade_no;
        }else if(ds_trade_no!=""){
            this.ds_trade_no=ds_trade_no;
        }
    }
}

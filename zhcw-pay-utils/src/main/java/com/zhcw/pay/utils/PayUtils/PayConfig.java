package com.zhcw.pay.utils.PayUtils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//支付相关参数
@Data
@ToString
@RequiredArgsConstructor
public class PayConfig extends Config {

    /**
     * 商户id
     * 必填
     */
    public String mp_id;
    /**
     * 渠道商系统付款交易号
     * 必填
     */
    public String ds_trade_no;
    /**
     * 付款金额，精确到小数2位  2位小数，如果是整数金额，用.00来格式化。
     * 举例：100.00，90.10【注意必须提供2位小数格式的金额，例如 100.00】
     * 必填
     */
    public String pay_fee;
    /**
     * 交易类型 WX-微信支付；AP-支付宝支付；【注意大写WX/AP】
     * 必填
     */
    public String trade_type;
    /**
     * 付款有效期，单位分钟 取值范围：5~1440分钟，如不提供，则系统取值1440分钟【24小时】。
     * 请在设定的时间范围内完成付款，如超过设定时间，将无法操作付款。
     * 必填
     */
    public int expire_time=60;//
    /**
     * 交易发起的客户端设备IP地址  微信，支付宝支付平台用以识别发起交易的客户端
     * 必填
     */
    public String user_ip;
    /**
     * 交易描述  交易商品描述 ,50个字符内，显示格式建议：【商户名称/网站名称】-【商品描述/门店描述】。
     * 交易商品描述将在微信/支付宝APP中的交易记录里做为商品描述被显示。
     * 选填
     */
    public String trade_subject;
    /**
     * 交易备注  使用交易备注允许渠道商系统传递自定义交易参数，200个字符内，
     * 系统在交易查询和交易异步通知返回结果时将原样返回此交易备注，方便渠道商系统处理返回的请求结果。
     * 选填
     */
    public String trade_memo;
    /**
     * 交易异步通知地址  由客户端提供URL，接收来自系统推送的交易数据，200个字符内详情参考本文档【交易异步通知】
     * 必填
     */
    public String notify_url;
    /**
     * 支付完成后页面回调地址  由客户端提供URL，系统在支付完成后将回调该URL，
     * 如果没有提供callback_url，支付完成后，将回到发起支付的页面。
     * 选填
     */
    public String callback_url;

    public void initParams(String mp_id,String ds_trade_no,String pay_fee,String trade_type,String trade_subject,String trade_memo,String notify_url,String callback_url,String user_ip){
        this.mp_id=mp_id;
        this.ds_trade_no=ds_trade_no;
        this.pay_fee=pay_fee;
        this.trade_type=trade_type;
        this.trade_subject=trade_subject;
        this.trade_memo=trade_memo;
        this.notify_url=notify_url;
        this.callback_url=callback_url;
        this.user_ip=user_ip;
    }
}

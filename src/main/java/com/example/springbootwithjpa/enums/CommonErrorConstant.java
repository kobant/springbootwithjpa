package com.example.springbootwithjpa.enums;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/27 14:17
 */
public enum  CommonErrorConstant {
    /**                    ----公共                                */
    COMMON_SUCCESS(1,"成功"),
    COMMON_FAIL(-1,"失败"),
    COMMON_TOKEN_MISSING(103,"token无效"),
    COMMON_ERROR(100001,"服务器内部错误"),
    COMMON_DATA_MISSING(100002,"数据缺失"),
    COMMON_REQ_MISSING(100003,"参数缺失"),
    COMMON_SYSTEM_BUSY(100004, "系统繁忙，请稍后再试"),
    COMMON_PARAM_ERROR(100005, "参数异常"),

    /**                    ----广告advert:11****                   */
    ADVERT_CODE_MISSING(110101,"广告组编码不存在"),


    /**                    ----活动activity:12****                 */
    // 邀请好友注册活动
    ACTIVITY_INVITE_NOT_FOUND(120001, "活动不存在"),
    ACTIVITY_INVITE_RECEIVE_FAIL(120002, "优惠券领取失败"),



    /**                    ----网关zuul/gateway:13****             */
    VERSION_EXPIRES(130001, "此版本不支持该功能，请升级到最新版本!"),

    /**                    ----商城shop:14****                     */


    /**                    ----tangram:15****                      */
    TANGRAM_PAGE_EXCEPTION(150001,"Tangram页面响应异常"),


    /**                    ----内容content:16****                  */
    ARTICLE_NOT_FOUND(160001, "文章已下架或已删除"),
    ARTICLE_CONTENT_ILLEGAL(160002, "非法文章内容"),



    /**                    ----会员member:17****                   */

    MEMBER_RECHARGE_QUOTA_NOT_EXIST(170001, "影视会员充值额度不存在"),
    MEMBER_RECHARGE_PRICE_INCORRECT(170002, "影视会员充值金额不一致"),
    MEMBER_RECHARGE_PAY_FAIL(170003, "影视会员充值下单失败"),
    MEMBER_RECHARGE_ORDER_NOT_EXIST(170004, "订单不存在"),

    /**                    ----积分point:18****                    */
    POINT_EXCHANGE_COUPON_MISSING(180001,"积分兑换券不存在"),
    POINT_NOT_ENOUGH(180002,"积分余额不足"),
    POINT_EXCHANGE_NUM_MAX(180003,"积分兑换券次数已达上限"),
    POINT_EXCHANGE_FAIL(180004,"兑换失败"),

    /**                    ----应用版本version:19****               */
    VERSION_NOT_SCORE(190001,"请评分"),
    VERSION_NOT_FEEDBACK(190002,"请输入反馈意见"),


    /**                    ----运营管理management:20****            */
    AUTH_ACCOUNT_INVALID(200001, "无效的账号"),
    AUTH_PUBLIC_EXPIRED(200002, "公钥已过期"),
    AUTH_PUBLIC_MISMATCH(200003, "公钥信息错误"),
    AUTH_PASSWORD_MISMATCH(200004, "认证信息错误"),
    AUTH_TOKEN_NOT_FOUND(200005, "token不能为空"),
    AUTH_NOT_PASS(200006, "请重新认证"),
    AUTH_ERROR(200007, "鉴权失败"),


    FINLISH(1,"");
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    CommonErrorConstant(int code, String msg) {
        this.msg = msg;
        this.code = code;

    }
}
package com.example.springbootwithjpa.enums;

public enum ErrCode {

    GET_ACCESS_TOKEN_FAIL(190000, "获取AccessToken失败"),
    SAVE_ERROR(180009, "保存失败"),
    DEL_ERROR(180010, "删除失败"),
    SAVE_ERROR_WAIT(180009, "保存失败，请稍后重试"),
    LOTTERY_ERROR(180011,"抽奖错误"),
    ERCODE_ERROR(180012,"二维码生成错误"),

    SAVEPRIZ_ERROR(180013,"选择的优惠卷不在有效期，请重新选则!"),
    CTYPE_NULL(190000, "活动标识不能为空"),
    PRIZECODENUM_REPEAT(190001, "输入的奖品编码已存在"),
    ACTIVITY_NAME_REPEAT(190002, "活动名称重复，请更改活动名称"),
    ACTIVITY_NULL(190003, "未找到对应活动"),

    CASHOUT_MIN_1(200001, "提现项上架数最小不能低于1个"),
    CASHOUT_MAX_6(200002, "提现项上架数最大不能超过6个"),

    RECEIVE_NULL(300001, "中奖信息id不能为空"),

    BONUSBALANCE_NOTENOUGH(400001, "奖金余额不足"),
    BONUSBALANCE_NULL(400002, "奖金余额不能为空"),
    AMOUNT_NULL(400003, "扣款金额不能为空"),

    ACTIVITY_POSTER_NULL(500001,"未配置对应活动海报"),
    ALIPAYACCOUNT_IS_NOT_NULL(500002,"该支付宝账户已被绑定，请检查账户信息。"),
    RECEIVEEMAIL_TO_LONG(120019,"收件邮箱长度过长"),

    DATA_INTEGRITY_VIOLATION_EXCEPTION(100100, "操作失败，违反了数据完整性，请检查数据"),

    FINLISH(1, "");

    private int code = -1;

    private String msgZ;

    private ErrCode(Integer code, String msgZ) {
        this.code = code;
        this.msgZ = msgZ;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsgZ() {
        return msgZ;
    }

    public void setMsgZ(String msgZ) {
        this.msgZ = msgZ;
    }

    public ErrCode resetMsgZ(String msgZ) {
        this.msgZ = msgZ;
        return this;
    }

    public ErrCode resetCode(int code) {
        this.code = code;
        return this;
    }

}

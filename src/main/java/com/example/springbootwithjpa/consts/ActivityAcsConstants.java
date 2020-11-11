package com.example.springbootwithjpa.consts;

public class ActivityAcsConstants {

    /**活动参与状态 1 进行中 2 已完成*/
    public static final String JOIN_STATUS_PROCESS="1";
    public static final String JOIN_STATUS_COMPLETE="2";

    /**卡券领取状态 1 未领取卡券 2 已领取卡券 3 已核销*/
    public static final String CARD_STATUS_RECEIVE_NO="1";
    public static final String CARD_STATUS_RECEIVE_YES="2";
    public static final String CARD_STATUS_USE="3";

    /**卡券获得来源 1 参与游戏 2 赠送*/
    public static final String GET_SOURCE_JOIN="0";
    public static final String GET_SOURCE_HANDSEL="1";

    /**领取状态: 1成功 2失败*/
    public static final String  CARD_STATUS_WX_RECEIVE_SUCCESS="1";
    public static final String  CARD_STATUS_WX_RECEIVE_FAILURE="2";
}

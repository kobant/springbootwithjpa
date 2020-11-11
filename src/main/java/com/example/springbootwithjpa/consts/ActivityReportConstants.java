package com.example.springbootwithjpa.consts;

/**
 * @Description
 * @Author TangHuaJie
 * @Date Created in 2020/10/28 17:22
 */
public class ActivityReportConstants {

    private ActivityReportConstants() {
        throw new UnsupportedOperationException("unsupported.");
    }

    // 汇总数据报表头
    public static final String[] SUMMARY_HEADER = {"序号", "兑换码", "创建时间", "是否有效", "编辑", "活动id",
			"用户id", "状态", "生成时间"};
    // 业务员报表头
    public static final String[] SALESMAN_HEADER = {"序号", "活动标题", "活动时间", "部门", "业务员姓名", "浏览经销商人数",
            "经销商海报数量", "访问用户数", "参与用户数", "领取卡券人数", "卡券核销数量"};
    // 经销商报表头
    public static final String[] DEALER_HEADER = {"序号", "活动标题", "活动时间", "经销商姓名", "门店名称", "业务员姓名",
            "部门", "访问用户数", "参与用户数", "领取卡券人数", "卡券核销数量"};
    // 用户报表头
    public static final String[] CUSTOMER_HEADER = {"序号", "兑换码", "创建时间", "是否有效", "编辑", "活动id",
            "用户id", "状态", "生成时间"};

    public static final String TO = "至";
    public static final String YES = "是";
    public static final String NO = "否";
}

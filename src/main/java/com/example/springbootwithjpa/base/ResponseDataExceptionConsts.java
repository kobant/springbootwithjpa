package com.example.springbootwithjpa.base;


import com.example.springbootwithjpa.utils.ResponseData;

public abstract class ResponseDataExceptionConsts {

	// 权益
	/**
	 * 未配置权益规则
	 */
	public static final ResponseData RIGHTS_EXCEPTION_500= new ResponseData<>(500, "未配置权益规则", "fail");

	/**
	 * 领取权益方式不正确
	 */
	public static final ResponseData RIGHTS_EXCEPTION_501= new ResponseData<>(501, "领取权益方式不正确", "fail");

	/**
	 * 权益规则不在有效期内
	 */
	public static final ResponseData RIGHTS_EXCEPTION_502= new ResponseData<>(502, "权益规则不在有效期内", "fail");

	/**
	 * 获取权益次数超出限制
	 */
	public static final ResponseData RIGHTS_EXCEPTION_503= new ResponseData<>(503, "获取权益次数超出限制", "fail");

	// 兑换
	/**
	 * 兑换规则类型不存在
	 */
	public static final ResponseData EXCHANGE_EXCEPTION_600 = new ResponseData<>(600, "兑换规则类型不存在", "fail");

	/**
	 * 兑换规则配置不存在
	 */
	public static final ResponseData EXCHANGE_EXCEPTION_601= new ResponseData<>(601, "兑换规则配置不存在", "fail");

	/**
	 * 当前日期不允许兑换
	 */
	public static final ResponseData EXCHANGE_EXCEPTION_602= new ResponseData<>(602, "当前日期不在开放时间内,请选择其他", "fail");

	/**
	 * 当日限制总量已兑完
	 */
	public static final ResponseData EXCHANGE_EXCEPTION_603= new ResponseData<>(603, "对不起,今天已被抢完,请选择其他", "fail");

	/**
	 * 当日权益已兑换
	 */
	public static final ResponseData EXCHANGE_EXCEPTION_604= new ResponseData<>(604, "对不起,今天您已经兑换,请下次再来", "fail");

	/**
	 * 当日多选一权益已兑完
	 */
	public static final ResponseData EXCHANGE_EXCEPTION_605= new ResponseData<>(605, "对不起,此多选一选项您已经兑换,请下次再来", "fail");

	// 金币
	/**
	 * 不支持的金币渠道类型
	 */
	public static final ResponseData COIN_EXCEPTION_1000 = new ResponseData<>(1000, "不支持的金币渠道类型", "fail");
	/**
	 * 金币不足无法兑换
	 */
	public static final ResponseData COIN_EXCEPTION_1002 = new ResponseData<>(1002, "金币不足无法兑换", "fail");
	/**
	 * 金币应为{{minTimes}}的整数倍才可以兑换
	 */
	public static final ResponseData COIN_EXCEPTION_1003 = new ResponseData<>(1003, "金币应为{{minTimes}}的整数倍才可以兑换", "fail");

	// 工分
	/**
	 * 工分数不正确
	 */
	public static final ResponseData WORKMIN_EXCEPTION_1503 = new ResponseData<>(1503, "工分数不正确", "fail");
	/**
	 * 没有配置积分兑换规则
	 */
	public static final ResponseData WORKMIN_EXCEPTION_1500 = new ResponseData<>(1500, "没有配置工分兑换规则", "fail");
	/**
	 * 工分不足无法兑换
	 */
	public static final ResponseData WORKMIN_EXCEPTION_1501 = new ResponseData<>(1501, "工分不足无法兑换", "fail");
	/**
	 * 工分应为{{minTimes}}的整数倍才可以兑换
	 */
	public static final ResponseData WORKMIN_EXCEPTION_1502 = new ResponseData<>(1502, "工分应为{{minTimes}}的整数倍才可以兑换", "fail");

	// 积分
	/**
	 * 积分数不正确
	 */
	public static final ResponseData POINT_EXCEPTION_2000 = new ResponseData<>(2000, "积分数不正确", "fail");
	/**
	 * 不支持的积分渠道类型
	 */
	public static final ResponseData POINT_EXCEPTION_2002 = new ResponseData<>(2002, "不支持的积分渠道类型", "fail");
	/**
	 * 积分不足无法兑换
	 */
	public static final ResponseData POINT_EXCEPTION_2003 = new ResponseData<>(2003, "积分不足无法兑换", "fail");
	/**
	 * 没有配置积分兑换规则
	 */
	public static final ResponseData POINT_EXCEPTION_2004 = new ResponseData<>(2004, "没有配置积分兑换规则", "fail");
	/**
	 * 积分应为{{minTimes}}的整数倍才可以兑换
	 */
	public static final ResponseData POINT_EXCEPTION_2005 = new ResponseData<>(2005, "积分应为{{minTimes}}的整数倍才可以兑换", "fail");

	// 津贴
	/**
	 * 没有配置津贴获取渠道
	 */
	public static final ResponseData ALLOWANCE_EXCEPTION_2500 = new ResponseData<>(2500, "没有配置津贴获取渠道", "fail");
	/**
	 * 津贴不足无法扣除
	 */
	public static final ResponseData ALLOWANCE_EXCEPTION_2501 = new ResponseData<>(2501, "津贴不足无法扣除", "fail");

	// 零钱
	/**
	 * 没有配置零钱兑换规则
	 */
	public static final ResponseData MONEY_EXCEPTION_3000 = new ResponseData<>(3000, "没有配置零钱兑换规则", "fail");
	/**
	 * 零钱数不正确
	 */
	public static final ResponseData MONEY_EXCEPTION_3001 = new ResponseData<>(3001, "零钱数不正确", "fail");
	/**
	 * 零钱不足无法提现
	 */
	public static final ResponseData MONEY_EXCEPTION_3002 = new ResponseData<>(3002, "零钱不足无法提现", "fail");
	/**
	 * 零钱应为{{minTimes}}的整数倍
	 */
	public static final ResponseData MONEY_EXCEPTION_3003 = new ResponseData<>(3003, "零钱应为{{minTimes}}的整数倍", "fail");
	/**
	 * 本月已经提现过
	 */
	public static final ResponseData MONEY_EXCEPTION_3004 = new ResponseData<>(3004, "本月已经提现过", "fail");
	/**
	 * 零钱每月{{fixDay}}号才能提现
	 */
	public static final ResponseData MONEY_EXCEPTION_3005 = new ResponseData<>(3005, "零钱每月{{fixDay}}号才能提现", "fail");
	/**
	 * 未满{{minTimes}}元不可提现
	 */
	public static final ResponseData MONEY_EXCEPTION_3007 = new ResponseData<>(3007, "未满{{minTimes}}元不可提现", "fail");
	/**
	 * 没有配置零钱提现规则
	 */
	public static final ResponseData MONEY_EXCEPTION_3008 = new ResponseData<>(3008, "没有配置零钱提现规则", "fail");

	public static final ResponseData MONEY_EXCEPTION_3009 = new ResponseData<>(3009, "不支持的零钱渠道类型", "fail");

	public static final ResponseData MONEY_EXCEPTION_3010 = new ResponseData<>(3009, "不支持的中奖零钱渠道类型", "fail");
	public static final ResponseData MONEY_EXCEPTION_3011 = new ResponseData<>(3002, "中奖零钱不足无法", "fail");

	// 收益
	/**
	 * 无效订单
	 */
	public static final ResponseData INTEREST_EXCEPTION_4000 = new ResponseData<>(4000, "无效订单", "fail");
	/**
	 * 不在收益领取周期内
	 */
	public static final ResponseData INTEREST_EXCEPTION_4001 = new ResponseData<>(4001, "不在收益领取周期内", "fail");
	/**
	 * 收益已经领完
	 */
	public static final ResponseData INTEREST_EXCEPTION_4002 = new ResponseData<>(4002, "收益已经领完", "fail");
	/**
	 * 今天已经领取过收益
	 */
	public static final ResponseData INTEREST_EXCEPTION_4003 = new ResponseData<>(4003, "今天已经领取过收益", "fail");
	/**
	 * 金额不足无法转入
	 */
	public static final ResponseData INTEREST_EXCEPTION_4005 = new ResponseData<>(4005, "金额不足无法转入", "fail");
	/**
	 * 可用收益不足无法提现
	 */
	public static final ResponseData INTEREST_EXCEPTION_4006 = new ResponseData<>(4006, "可用收益不足无法提现", "fail");
	/**
	 * 收益应为{{minTimes}}的整数倍才可以转入零钱
	 */
	public static final ResponseData INTEREST_EXCEPTION_4007 = new ResponseData<>(4007, "收益应为{{minTimes}}的整数倍才可以转入零钱", "fail");
	/**
	 * 未达到提现额度，请转入零钱
	 */
	public static final ResponseData INTEREST_EXCEPTION_4009 = new ResponseData<>(4009, "未达到提现额度，请转入零钱", "fail");
	/**
	 * 本月已经转过零钱
	 */
	public static final ResponseData INTEREST_EXCEPTION_4010 = new ResponseData<>(4010, "本月已经转过零钱", "fail");
	/**
	 * 本月已经提现过
	 */
	public static final ResponseData INTEREST_EXCEPTION_4011 = new ResponseData<>(4011, "本月已经提现过", "fail");
	/**
	 * 收益每月{{fixDay}}号才能提现
	 */
	public static final ResponseData INTEREST_EXCEPTION_4012 = new ResponseData<>(4012, "收益每月{{fixDay}}号才能提现", "fail");
	/**
	 * 没有配置收益转零钱规则
	 */
	public static final ResponseData INTEREST_EXCEPTION_4013 = new ResponseData<>(4013, "没有配置收益转零钱规则", "fail");
	/**
	 * 没有配置收益提现规
	 */
	public static final ResponseData INTEREST_EXCEPTION_4014 = new ResponseData<>(4014, "没有配置收益提现规则", "fail");
	/**
	 * 收益应为{{minTimes}}的整数倍才可以提现
	 */
	public static final ResponseData INTEREST_EXCEPTION_4015 = new ResponseData<>(4015, "收益应为{{minTimes}}的整数倍才可以提现", "fail");
	/**
	 * 收益未满1年不可提现
	 */
	public static final ResponseData INTEREST_EXCEPTION_4016 = new ResponseData<>(4016, "收益未满1年不可提现", "fail");
	/**
	 * 您还没有收益
	 */
	public static final ResponseData INTEREST_EXCEPTION_4017 = new ResponseData<>(4017, "您还没有收益", "fail");
	/**
	 * 未满{{minTimes}}元不可提现
	 */
	public static final ResponseData INTEREST_EXCEPTION_4018 = new ResponseData<>(4018, "未满{{minTimes}}元不可提现", "fail") ;

	public static final ResponseData INTEREST_EXCEPTION_4019 = new ResponseData<>(4019, "暂时不能领取", "fail") ;

	// 银行卡
	/**
	 * 未绑定银行卡，请先绑卡
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5000 = new ResponseData<>(5000, "未绑定银行卡，请先绑卡", "fail");
	/**
	 * 持卡人名为空
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5001 = new ResponseData<>(5001, "持卡人名为空", "fail");
	/**
	 * 银行卡号不正确
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5002 = new ResponseData<>(5002, "银行卡号不正确", "fail");
	/**
	 * 发卡行为空
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5003 = new ResponseData<>(5003, "发卡行为空", "fail");
	/**
	 * 手机号码不正确
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5004 = new ResponseData<>(5004, "手机号码不正确", "fail");
	/**
	 * 绑卡数达到上限
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5005 = new ResponseData<>(5005, "绑卡数达到上限", "fail");
	/**
	 * 同一个银行只能绑定一张卡
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5006 = new ResponseData<>(5006, "同一个银行只能绑定一张卡", "fail");
	/**
	 * 该卡号已绑定
	 */
	public static final ResponseData BANKACCOUNT_EXCEPTION_5007 = new ResponseData<>(5007, "该卡号已绑定", "fail");

	// 通用
	/**
	 * 系统繁忙，请稍后重试
	 */
	public static final ResponseData COMMON_EXCEPTION_6000 = new ResponseData<>(6000, "系统繁忙，请稍后重试", "fail");
	public static final ResponseData COMMON_EXCEPTION_6001 = new ResponseData<>(6001, "请求不合法", "fail");


	// 发票
	public static final ResponseData INVOICE_EXCEPTION_7000 = new ResponseData<>(7000, "请上传发票图片", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7001 = new ResponseData<>(7001, "发票上传服务暂时不可用,请明天再来", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7002 = new ResponseData<>(7002, "仅支持增值税普通发票", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7003 = new ResponseData<>(7003, "无效图片", "fail");

	public static final ResponseData INVOICE_EXCEPTION_7007 = new ResponseData<>(7007, "发票超过当天查验次数", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7008 = new ResponseData<>(7008, "发票信息不一致", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7009 = new ResponseData<>(7009, "所查发票不存在", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7010 = new ResponseData<>(7010, "查询发票不规范", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7012 = new ResponseData<>(7012, "当天发票不支持", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7013 = new ResponseData<>(7013, "开票日期超过当前时间", "fail");

	public static final ResponseData INVOICE_EXCEPTION_7016 = new ResponseData<>(7016, "填写的发票号码和发票代码与上传的不同", "fail");

	public static final ResponseData INVOICE_EXCEPTION_7017 = new ResponseData<>(7017, "产品SN码{sn}已经存在", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7018 = new ResponseData<>(7018, "发票号码应为8位数字", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7019 = new ResponseData<>(7019, "发票代码应为10或12位数字", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7020 = new ResponseData<>(7020, "发票号和代码已经存在", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7021 = new ResponseData<>(7020, "发票号和代码使用次数超出限制", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7023 = new ResponseData<>(7023, "请输入发票号", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7024 = new ResponseData<>(7024, "请输入发票代码", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7025 = new ResponseData<>(7025, "不是增值税普通发票", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7028 = new ResponseData<>(7028, "该发票对应的订单在收益列表中,不需要上传发票", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7029 = new ResponseData<>(7029, "产品SN码{sn}不正确", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7030 = new ResponseData<>(7030, "发票上传次数达到上限", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7031 = new ResponseData<>(7031, "图片大小应小于{maxSize}M", "fail") ;

	public static final ResponseData INVOICE_EXCEPTION_7032 = new ResponseData<>(7032, "图片格式应为jpg/jpeg/png/bmp之一", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7033 = new ResponseData<>(7033, "图片上传失败，请稍后重试", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7034 = new ResponseData<>(7034, "账号禁止上传发票并操作", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7035 = new ResponseData<>(7035, "属于ID黑名单禁止上传", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7036 = new ResponseData<>(7036, "对不起，发票无效，请提供TCL相关的发票", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7037 = new ResponseData<>(7037, "对不起，发票已被使用", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7038 = new ResponseData<>(7038, "图片识别功能暂时不可用，请稍后重试", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7039 = new ResponseData<>(7039, "当前有发票审核中，无法上传", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7040 = new ResponseData<>(7040, "每人最多上传{maxUpload}张发票", "fail") ;
	public static final ResponseData INVOICE_EXCEPTION_7041 = new ResponseData<>(7041, "开票日期为空", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7042 = new ResponseData<>(7042, "请完善发票信息", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7043 = new ResponseData<>(7043, "请完善发票内容", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7044 = new ResponseData<>(7044, "请选择品类", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7045 = new ResponseData<>(7045, "请填写产品SN码", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7046 = new ResponseData<>(7046, "产品SN码{sn}不正确", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7047 = new ResponseData<>(7047, "发票上传额度已经达到上限，请明天再来", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7048 = new ResponseData<>(7048, "未能识别到发票信息，请重新上传", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7049 = new ResponseData<>(7049, "发票号和代码已经在审核中", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7050 = new ResponseData<>(7050, "价税合计不能为空", "fail");
	public static final ResponseData INVOICE_EXCEPTION_7051 = new ResponseData<>(7051, "请上传普通发票", "fail");


	public static final ResponseData SALESPERSON_EXCEPTION_8000 = new ResponseData<>(8000, "请选择正确的EXCEL文件导入", "fail");
}

package com.example.springbootwithjpa.entity;

import org.springframework.validation.BindingResult;



/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/10 17:19
 */

public class Result {

	//操作成功
	public static final int SUCCESS = 200;
	//操作失败
	public static final int FAILED = 500;
	//参数校验失败
	public static final int VALIDATE_FAILED = 404;
	//未认证
	public static final int UNAUTHORIZED = 401;
	//未授权
	public static final int FORBIDDEN = 403;
	private int code;
	private String msg;
	private Object data;

	/**
	 * 普通成功返回
	 *
	 * @param data 获取的数据
	 */
	public Result success(Object data) {
		this.code = SUCCESS;
		this.msg = "操作成功";
		this.data = data;
		return this;
	}
	/**
	 * 普通成功返回
	 *
	 */
	public Result success() {
		this.code = SUCCESS;
		this.msg = "操作成功";
		this.data =  "操作成功";
		return this;
	}
	/**
	 * 普通成功返回
	 */
	public Result success(String msg, Object data) {
		this.code = SUCCESS;
		this.msg = msg;
		this.data = data;
		return this;
	}


	/**
	 * 普通失败提示信息
	 */
	public Result failed() {
		this.code = FAILED;
		this.msg = "操作失败";
		return this;
	}

	public Result failed(String msg) {
		this.code = FAILED;
		this.msg = msg;
		return this;
	}

	/**
	 * 参数验证失败使用
	 *
	 * @param msg 错误信息
	 */
	public Result validateFailed(String msg) {
		this.code = VALIDATE_FAILED;
		this.msg = msg;
		return this;
	}

	/**
	 * 未登录时使用
	 *
	 * @param msg 错误信息
	 */
	public Result unauthorized(String msg) {
		this.code = UNAUTHORIZED;
		this.msg = "暂未登录或token已经过期";
		this.data = msg;
		return this;
	}

	/**
	 * 未授权时使用
	 *
	 * @param msg 错误信息
	 */
	public Result forbidden(String msg) {
		this.code = FORBIDDEN;
		this.msg = "没有相关权限";
		this.data = msg;
		return this;
	}

	/**
	 * 参数验证失败使用
	 *
	 * @param result 错误信息
	 */
	public Result validateFailed(BindingResult result) {
		validateFailed(result.getFieldError().getDefaultMessage());
		return this;
	}
	/**
	 * 普通失败提示信息
	 */
	public Result paramFailed() {
		this.code = FAILED;
		this.msg = "参数失败";
		return this;
	}

	public Result paramFailed(String msg) {
		this.code = FAILED;
		this.msg = msg;
		return this;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getmsg() {
		return msg;
	}

	public void setmsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

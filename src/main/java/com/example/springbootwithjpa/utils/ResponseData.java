package com.example.springbootwithjpa.utils;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/9 15:20
 */
public class ResponseData<T> {


	private int code;

	private String msgZ;

	private String msgE;

	private T data;

	public ResponseData() {
		code = 1;
		msgZ = "成功";
		msgE = "success";
	}

	public ResponseData(T data) {
		code = 1;
		msgZ = "成功";
		msgE = "success";
		this.data = data;
	}

	public ResponseData(int code, String msgZ, String msgE) {
		this.code = code;
		this.msgZ = msgZ;
		this.msgE = msgE;
	}

	public ResponseData(int code, String msgZ, String msgE, T data) {
		this.code = code;
		this.msgZ = msgZ;
		this.msgE = msgE;
		this.data = data;
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

	public String getMsgE() {
		return msgE;
	}

	public void setMsgE(String msgE) {
		this.msgE = msgE;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 请求是否成功
	 *
	 * @return
	 */
	public boolean isSuccess() {
		if (code == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static final String ERROR_WEIXIN = "{\"code\": 80, \"msgZ\": \"weixin third error\", \"msgE\": \"weixin third error\"}";
}

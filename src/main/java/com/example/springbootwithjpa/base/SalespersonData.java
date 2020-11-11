package com.example.springbootwithjpa.base;

import com.example.springbootwithjpa.entity.MemSalespersonModel;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/9 15:10
 */
public class SalespersonData extends MemSalespersonModel {
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}

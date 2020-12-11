package com.example.springbootwithjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/8 18:18
 */
@Entity
@Table(name = "employee")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "lastName", columnDefinition ="varchar(255) DEFAULT NULL COMMENT '员工名字'")
	private String lastName;

	@Column(name = "email", columnDefinition ="varchar(255) DEFAULT NULL COMMENT '邮编'")
	private String email;

	@Column(name = "gender", columnDefinition = "int(11) DEFAULT 0 COMMENT '助力限制 1 一个人只能帮一个好友助力 2 一个人可以为多个好友助力'")
	private Integer gender;

	@Column(name = "d_id", columnDefinition = "int(11) DEFAULT 0 COMMENT '助力门槛人数'")
	private Integer d_id;

	/*@Column(name = "gender", columnDefinition = "int(11) DEFAULT 0 COMMENT '性别'")
	private Integer gender;

	@Column(name = "gender", columnDefinition ="int(11) DEFAULT 0 COMMENT '部门id'")
	private Integer d_id;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
}

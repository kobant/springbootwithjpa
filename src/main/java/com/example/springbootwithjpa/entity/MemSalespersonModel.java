package com.example.springbootwithjpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/9 15:08
 */
@Entity
@Table(name = "mem_salesperson")
public class MemSalespersonModel {

	public MemSalespersonModel() {

	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "mobile", columnDefinition = "varchar(24) NOT NULL COMMENT '手机号'")
	private String mobile;

	@Column(name = "name", columnDefinition = "varchar(32) COMMENT '姓名'")
	private String name;

	@Column(name = "cate", columnDefinition = "varchar(48) COMMENT '品类'")
	private String cate;

	@Column(name = "center", columnDefinition = "varchar(48) COMMENT '管理中心'")
	private String center;

	@Column(name = "type", columnDefinition = "int(2) DEFAULT 0 COMMENT '类型，0：销售代表，1：售后 '")
	private int type;

	@Column(name = "state", columnDefinition = "int(2) DEFAULT 0 COMMENT '状态，0：可用，1：删除 '")
	private int state;

	@Column(name = "creator", columnDefinition = "varchar(32) COMMENT '创建人'")
	private String creator;

	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
	private Timestamp createTime;

	@Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'")
	private Timestamp updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}

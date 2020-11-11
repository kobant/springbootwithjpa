package com.example.springbootwithjpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/9 13:53
 */
@Entity
@Table( name ="mem_marketing_luck_invoice")
public class MemMarketingLuckInvoiceModel{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" ,columnDefinition="int(8) NOT NULL DEFAULT 0 COMMENT 'null'")
	private Long id;

	@Column(name = "luck_everday_id" ,columnDefinition="int(8) NOT NULL COMMENT '活动ID'")
	private Long luckEverdayId;

	@Column(name = "mem_uid" ,columnDefinition="varchar(32) NULL COMMENT '会员ID'")
	private String memUid;

	@Column(name = "mobile" ,columnDefinition="varchar(32) NULL COMMENT '手机号'")
	private String mobile;

	@Column(name = "nick_name" ,columnDefinition="varchar(32) NULL COMMENT '昵称'")
	private String nickName;

	@Column(name = "sort" ,columnDefinition="tinyint(1) NOT NULL DEFAULT 0 COMMENT '品类'")
	private Integer sort;

	@Column(name = "serial_num" ,columnDefinition="varchar(32) NULL COMMENT '设备序列号'")
	private String serialNum;

	@Column(name = "telphone" ,columnDefinition="varchar(32) NULL COMMENT '填写手机号'")
	private String telphone;

	@Column(name = "invoice_img" ,columnDefinition="varchar(32) NULL COMMENT '发票'")
	private String invoiceImg;

	@Column(name = "create_time" ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间'")
	private Timestamp createTime;

	@Column(name = "status" ,columnDefinition="tinyint(1) NOT NULL DEFAULT 0 COMMENT '审批状态2-不通过，1-通过'")
	private Integer status;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLuckEverdayId() {
		return luckEverdayId;
	}

	public void setLuckEverdayId(Long luckEverdayId) {
		this.luckEverdayId = luckEverdayId;
	}

	public String getMemUid() {
		return this.memUid;
	}

	public void setMemUid(String memUid) {
		this.memUid = memUid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getInvoiceImg() {
		return this.invoiceImg;
	}

	public void setInvoiceImg(String invoiceImg) {
		this.invoiceImg = invoiceImg;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
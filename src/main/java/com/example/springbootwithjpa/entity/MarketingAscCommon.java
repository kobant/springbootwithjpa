package com.example.springbootwithjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @Description: 用于展示的公共部分
 * @Author: liaocongcong
 * @Date: 2020/10/27 16:28
 */

@Entity
@Table( name ="markting_asc_common")
public class MarketingAscCommon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "activity_config_no", columnDefinition ="varchar(32) DEFAULT NULL COMMENT '活动配置编码'")
	private String activityConfigNo;

	@Column(name = "activity_name", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '活动名称'")
	private String activityName;

	@Column(name = "activity_type", columnDefinition = "varchar(2) DEFAULT NULL COMMENT '活动类型'")
	private String activityType;

	@Column(name = "start_time", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '开始时间'")
	private String startTime;

	@Column(name = "end_time", columnDefinition = "varchar(33) DEFAULT NULL COMMENT '结束时间'")
	private String endTime;

	@Column(name = "use_status", columnDefinition = "int(1) DEFAULT 1 COMMENT '伪删除 1:使用, 0:逻辑删除'",insertable = false)
	private Integer useStatus;

	@Column(name = "userId", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '创建人'")
	private String userId;

	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @JsonFormat(timezone = "GMT-6", locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

	@Column(name = "activity_router_url", columnDefinition = "varchar(60) DEFAULT NULL COMMENT '活动地址'")
	private String activityRouterUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivityConfigNo() {
		return activityConfigNo;
	}

	public void setActivityConfigNo(String activityConfigNo) {
		this.activityConfigNo = activityConfigNo;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getActivityRouterUrl() {
		return activityRouterUrl;
	}

	public void setActivityRouterUrl(String activityRouterUrl) {
		this.activityRouterUrl = activityRouterUrl;
	}
}

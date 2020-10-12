package com.example.springbootwithjpa.entity;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/12 14:52
 */
@Data
@Entity
@Table(name = "jpa_permission")
@org.hibernate.annotations.Table(appliesTo = "jpa_permission", comment = "权限表")
public class JpaPermission {

	@Id
	@GeneratedValue
	@ApiParam("主键ID")
	@Column(name = "id",length = 20)
	protected Long id;

	@ApiParam("权限名称")
	@Column(name = "permission_name",columnDefinition = "VARCHAR(64) NOT NULL COMMENT '权限名称'")
	private String permissionName;
}

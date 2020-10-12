package com.example.springbootwithjpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/12 14:56
 */
@Data
@Entity
@Table(name = "jpa_role")
@org.hibernate.annotations.Table(appliesTo = "jpa_role", comment = "角色表")
public class JpaRole {

	@Id
	@GeneratedValue
	@ApiParam("主键ID")
	@Column(name = "id")
	private Long id;

	@ApiParam("角色名")
	@Column(name = "role_name", columnDefinition = "VARCHAR(64) NOT NULL COMMENT '角色名'")
	private String roleName;

	@JsonBackReference
	@OneToMany(targetEntity = JpaUser.class, mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	private List<JpaUser> jpaUsers;

	/**
	 * 一对一的关系 在其中一个表维护就好了
	 */
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "permission_id")
	private JpaPermission permission;
}

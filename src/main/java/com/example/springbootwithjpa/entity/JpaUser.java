package com.example.springbootwithjpa.entity;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/12 14:36
 */
@Data
@Entity
@Table(name = "jpa_user")
@org.hibernate.annotations.Table(appliesTo = "jpa_user", comment = "用户表")
public class JpaUser {
	@Id
	@GeneratedValue
	@ApiParam("主键ID")
	@Column(name = "id", length = 20)
	private Long id;

	@ApiParam("用户名")
	@Column(name = "user_name", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '用户名'")
	private String userName;

	@ApiParam("昵称")
	@Column(name = "nick_name", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '昵称'")
	private String nickName;

	@ApiParam("岗位")
	@Column(name = "position")
	private String position;

	@ApiParam("年龄")
	@Column(name = "age")
	private Integer age;

	@Column(name = "longitude", precision = 10, scale = 7)
	private BigDecimal longitude;

	@Column(name = "latitude", precision = 10, scale = 7)
	private BigDecimal latitude;

	/**
	 * @ManyToOne 用户:角色 多个用户对应一个角色，当我们创建表结构时，应在多的一方去维护表关系，也就是说，应将@ManyToOne注解加在用户表中，并且设置为懒加载。
	 * @JsonBackReference 生成json时该属性排除
	 */
    @ManyToOne
	@JoinColumn(name = "role_id")
	private JpaPermission role;

}

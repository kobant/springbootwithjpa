package com.example.springbootwithjpa.entity;


import javax.persistence.*;


/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/10 16:20
 */

@Entity
@Table(name = "new_user")
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "u_name" ,columnDefinition = "varchar(16) not null default '' comment '用户姓名'")
	private String name;

	@Column(name = "u_email",columnDefinition = "varchar(16) not null default '' comment '用户邮编'")
	private String email;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

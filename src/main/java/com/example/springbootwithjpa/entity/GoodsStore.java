package com.example.springbootwithjpa.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 11:30
 */
@Data
@Entity
@Table(name="goods_store")
public class GoodsStore implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	@Column(name="store")
	private int store;

	//get、set省略
}
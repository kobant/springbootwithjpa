package com.example.springbootwithjpa.entity;

import lombok.Data;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 9:15
 */
@Data
public class BookQuery {

	private String name;
	private String isbn;
	private String author;
	//此处省去get、set方法
}

package com.example.springbootwithjpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 创建时间 2020/10/15 9:12
 */
@Data
@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(nullable = false,name = "name")
	private String name;

	@Column(nullable = false,name = "isbn")
	private String isbn;

	@Column(nullable = false,name = "author")
	private String author;

	public Book (String name,String isbn,String author){
		this.name = name;
		this.isbn = isbn;
		this.author = author;
	}
	public Book(){

	}
	//此处省去get、set方法


}
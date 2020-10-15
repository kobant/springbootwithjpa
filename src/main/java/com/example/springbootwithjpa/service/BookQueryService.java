package com.example.springbootwithjpa.service;

import com.example.springbootwithjpa.entity.Book;
import com.example.springbootwithjpa.entity.BookQuery;
import org.springframework.data.domain.Page;

/**
 *
 * 分页查询条件
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 9:29
 */

public interface BookQueryService {

	/**
	 * 无条件
	 * @param page 当前页码
	 * @param size 每页显示数量
	 * @return
	 */
	Page<Book> findBookNoCriteria(Integer page,Integer size);

	/**
	 *
	 * @param page 当前页码
	 * @param size  每页显示数量
	 * @param bookQuery  查询条件
	 * @return
	 */
	Page<Book> findBookCriteria(Integer page, Integer size, BookQuery bookQuery);

}

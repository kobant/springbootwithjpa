package com.example.springbootwithjpa.dao;

import com.example.springbootwithjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 9:24
 */
@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book,Long>
		, JpaSpecificationExecutor<Book> {
}

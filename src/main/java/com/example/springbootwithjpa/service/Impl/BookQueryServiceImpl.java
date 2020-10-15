package com.example.springbootwithjpa.service.Impl;

import com.example.springbootwithjpa.dao.BookRepository;
import com.example.springbootwithjpa.entity.Book;
import com.example.springbootwithjpa.entity.BookQuery;
import com.example.springbootwithjpa.service.BookQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 9:32
 */
@Service(value="bookQueryService")
public class BookQueryServiceImpl implements BookQueryService {

	@Resource
	BookRepository bookRepository;

	/**
	 * 不加条件
	 *
	 * @param page 当前页码
	 * @param size 每页显示数量
	 * @return
	 */
	@Override
	public Page<Book> findBookNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page,size, Sort.Direction.ASC,"id");
		return bookRepository.findAll(pageable);
	}

	/**
	 * 条件进行分页查询
	 * @param page 当前页码
	 * @param size  每页显示数量
	 * @param bookQuery  查询条件
	 * @return
	 */
	@Override
	public Page<Book> findBookCriteria(Integer page, Integer size,final BookQuery bookQuery) {
		Pageable pageable = new PageRequest(page,size,Sort.Direction.ASC,"id");
		Page<Book> bookPage = bookRepository.findAll(new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<>();
				if (null!=bookQuery.getIsbn()&&!"".equals(bookQuery.getName())){
					list.add(criteriaBuilder.equal(root.get("name").as(String.class),bookQuery.getName()));
				}
				if(null!=bookQuery.getIsbn()&&!"".equals(bookQuery.getIsbn())){
					list.add(criteriaBuilder.equal(root.get("isbn").as(String.class), bookQuery.getIsbn()));
				}
				if(null!=bookQuery.getAuthor()&&!"".equals(bookQuery.getAuthor())){
					list.add(criteriaBuilder.equal(root.get("author").as(String.class), bookQuery.getAuthor()));
				}

				Predicate[] p = new Predicate[list.size()];

				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
		return bookPage;
	}
}

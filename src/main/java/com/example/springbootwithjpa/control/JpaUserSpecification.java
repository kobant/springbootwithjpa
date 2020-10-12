package com.example.springbootwithjpa.control;

import com.example.springbootwithjpa.entity.JpaUser;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/12 15:26
 */

public class JpaUserSpecification implements Specification<JpaUser> {


	@Override
	public Specification<JpaUser> and(Specification<JpaUser> other) {
		return null;
	}

	@Override
	public Specification<JpaUser> or(Specification<JpaUser> other) {
		return null;
	}

	@Override
	public Predicate toPredicate(Root<JpaUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
		return null;
	}
}

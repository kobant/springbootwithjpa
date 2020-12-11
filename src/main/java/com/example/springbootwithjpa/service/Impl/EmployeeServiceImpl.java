package com.example.springbootwithjpa.service.Impl;


import com.example.springbootwithjpa.dao.EmployeeRepstory;
import com.example.springbootwithjpa.entity.Employee;
import com.example.springbootwithjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/8 18:47
 */
@Transactional
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepstory employeeRepstory;

	@Override
	@Transactional
	@Cacheable(cacheNames = {"emp"})
	public Employee findbyid(Integer id) {
		Employee byId = employeeRepstory.getOne(id);
		return byId;
	}
}

package com.example.springbootwithjpa.dao;

import com.example.springbootwithjpa.base.SalespersonData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/9 15:12
 */

public interface MemSalespersonDao {
	Page<SalespersonData> search(String mobile, String nickname, Integer type, String cate, String center, String name, Pageable pageable);
}

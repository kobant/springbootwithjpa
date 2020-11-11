package com.example.springbootwithjpa.service;

import com.example.springbootwithjpa.base.SalespersonData;
import com.example.springbootwithjpa.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/9 15:19
 */

public interface MemSalespersonService {
	public ResponseData<Page<SalespersonData>> search(String mobile, String nickname, Integer type, String cate, String center, String name, Pageable pageable);

	ResponseData<int[]> updateStateByIds(Long[] ids);

	ResponseData<Boolean> exists(String memUid);

	//Workbook exportDatas(String mobile, String nickname, Integer type, String cate, String center, String name);

	String exportDatasCsv(String mobile, String nickname, Integer type, String cate, String center, String name);

	ResponseData<Integer> importDatas(MultipartFile file, String creator);
}

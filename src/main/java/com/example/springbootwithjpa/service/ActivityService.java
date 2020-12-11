package com.example.springbootwithjpa.service;

import com.example.springbootwithjpa.model.ActivityLotteryCKeyModel;
import com.example.springbootwithjpa.utils.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/10 14:38
 */

public interface ActivityService {
	/**
	 * 根据输入的number导出csv文件
	 * @param number
	 * @return
	 */
	public void fingExpro(Integer number, HttpServletResponse response) throws Exception;


	/**
	 * 根据数量查询
	 * @param number
	 * @return
	 */
	public List<ActivityLotteryCKeyModel> fingExpro(Integer number);


	/**
	 * 打印csv
	 * @param list
	 * @param path
	 */
	public void generateActivityCsv(List<ActivityLotteryCKeyModel> list,String path);


	/**
	 * 测试cvs 2.0
	 * @param list
	 * @return
	 */
	public String exportDatasCsv(List<ActivityLotteryCKeyModel> list);


	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Optional<ActivityLotteryCKeyModel> findById(Integer id);


	/**
	 * 导入文件
	 * @param file
	 * @return
	 */
	public ResponseData<Integer> importDatas(MultipartFile file);
}

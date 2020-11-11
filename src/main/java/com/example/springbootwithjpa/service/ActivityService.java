package com.example.springbootwithjpa.service;

import com.example.springbootwithjpa.model.ActivityLotteryCKeyModel;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
}

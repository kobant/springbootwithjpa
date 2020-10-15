package com.example.springbootwithjpa.service;

import com.example.springbootwithjpa.entity.GoodsStore;

/**
 *
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 15:41
 */

public interface GoodsStoreFacade {

	/**
	 * 根据产品编号更新库存
	 * @param code
	 * @return
	 */
	String updateGoodsStore(String code,int count);

	/**
	 * 获取库存对象
	 * @param code
	 * @return
	 */
	GoodsStore getGoodsStore(String code);
}

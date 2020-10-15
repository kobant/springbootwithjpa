package com.example.springbootwithjpa.dao;

import com.example.springbootwithjpa.entity.GoodsStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 15:29
 */

public interface GoodsStoreRespository extends JpaRepository<GoodsStore,String> {

	/**
	 * 数据跟新
	 *
	 * @param code
	 * @param store
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update GoodsStore gs set gs.store=gs.store-?2 where gs.code=?1")
	int updateStore(@Param("code") String code, @Param("store")Integer store);
}

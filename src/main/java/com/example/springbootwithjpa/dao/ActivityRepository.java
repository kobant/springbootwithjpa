package com.example.springbootwithjpa.dao;

import com.example.springbootwithjpa.model.ActivityLotteryCKeyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/10 14:27
 */

public interface ActivityRepository extends JpaRepository<ActivityLotteryCKeyModel, Integer>, JpaSpecificationExecutor<ActivityLotteryCKeyModel> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true ,value="SELECT id,code,cre_time,is_delete,mod_time,ninelattices_id,ssoid,status,tx_time FROM activity_lottery_ckey_model a  ORDER BY id DESC LIMIT ?1" )
	public List<ActivityLotteryCKeyModel> fingExpro(Integer number);

    @Query(nativeQuery = true ,value="SELECT id,code,cre_time,is_delete,mod_time,ninelattices_id,ssoid,status,tx_time FROM activity_lottery_ckey_model where id=?1")
	ActivityLotteryCKeyModel findByIds(Long id);

}

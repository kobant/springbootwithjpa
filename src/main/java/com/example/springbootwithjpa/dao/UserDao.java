package com.example.springbootwithjpa.dao;

import com.example.springbootwithjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.
 * 创建时间 2020/10/10 16:25
 */

public interface UserDao extends JpaRepository<User,Integer> {

	@Query(nativeQuery=true,value="select * from user order by id")
	public List<User> getAll();

	@Query("select u from User u where u.name= ?1")
	public User findName(String name);

	@Query("select u from User u where u.id= ?1")
	public User findByUserId(Integer id);

    @Transactional
	@Modifying
	@Query("delete from User where id=?1")
	public  int deleteUser(Integer id);

    @Modifying
	@Transactional
	@Query("delete from User u where u.id in (:ids)")
    public void deleteList(@Param("ids") Integer[] ids);

    @Query(nativeQuery = true,value="select u.* ,j.role_name from jpa_user u  join jpa_role j on u.role_id=j.id and user_name like %?1%" )
	public Object getByll(String userName );


}

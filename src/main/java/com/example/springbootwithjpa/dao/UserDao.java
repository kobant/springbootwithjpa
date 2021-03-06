package com.example.springbootwithjpa.dao;

import com.example.springbootwithjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

public interface UserDao extends  JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

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

	@Modifying
	//@Transactional
	@Query(value="update new_user set u_name =u.name ,u_email =u.email where id =u.id",nativeQuery = true)
	public void update(User u);

    @Query(nativeQuery = true,value="select u.* ,j.role_name from jpa_user u  join jpa_role j on u.role_id=j.id and user_name like %?1%" )
	public Object getByll(String userName );

	@Transactional
	@Modifying
    @Query(nativeQuery = true ,value="insert into user (u_email, u_name) VALUES (user.u_email,user.u_name )")
	public int addUser(User u);

}

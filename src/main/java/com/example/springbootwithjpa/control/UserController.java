package com.example.springbootwithjpa.control;

import com.example.springbootwithjpa.dao.UserDao;
import com.example.springbootwithjpa.entity.CommonResult;

import com.example.springbootwithjpa.entity.JpaUser;
import com.example.springbootwithjpa.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/10 16:26
 */
@Controller
@Api(tags = "UserController", description = "用户管理系统")
public class UserController {

	@Autowired
    UserDao userDao;

	@ApiOperation("查询全部员工根据Id排序")
	@GetMapping("/hello/getAlls")
	@ResponseBody
	public Object getAlls(){
		List<User> all = userDao.getAll();
		if (all!=null){
			return new CommonResult().success("查询成功！",all);
		}else {
			return new CommonResult().failed("查询失败！");
		}
	}



	/**
	 * 真的提交一次
	 * @return
	 */
	@ApiOperation("发起拼团")
	@GetMapping("/hello")
	@ResponseBody
	public Object hello(){

		List<User> all = userDao.findAll();

		return  new CommonResult().success(all);
	}

	/**
	 * 我也提交吧
	 * @param id
	 * @return
	 */
	@GetMapping("/hello/{id}")
	@ResponseBody
	@ApiOperation(value = "根据主键查询对象",notes = "员工编号必须传递")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id不用传",  required = false,dataType="Integer")
	})
	public Object hello(@PathVariable("id") Integer id){
		User one = userDao.findByUserId(id);
		if (one!=null){
			return new CommonResult().success("查询成功！",one);
		}else {
			return new CommonResult().failed("查询失败！");
		}

	}

	@PostMapping("/hello/add")
	@ApiOperation("保存对象USER")
	public Object saveUser(User user){

		return userDao.save(user);
	}

	@GetMapping("/helloname/{name}")
	@ResponseBody
	public Object hello(@PathVariable("name") String name){
		User name1 = userDao.findName(name);
		if (name1!=null){
			return new CommonResult().success("查询成功！",name1);
		}else {
			return new CommonResult().failed("无此用户信息！");
		}

	}


	/**
	 * 测试
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	@ResponseBody
	public Object delete(@PathVariable("id") Integer id){
		int b = userDao.deleteUser(id);
        if (b>0){
			return new CommonResult().success("删除成功！");
		}else {
			return new CommonResult().failed("删除操作失败！");
		}

	}

	@GetMapping("/deletes")
	@ResponseBody
	public Object deletes(Integer[] id){
		userDao.deleteList(id);

		return new CommonResult().success();
	}

	@GetMapping("/getjoin/{username}")
	@ResponseBody
	public Object getjoin(@PathVariable("username") String username){
		Object name = userDao.getByll(username);
		System.out.println(username);
		if (name!=null){
			return new CommonResult().success("查询成功！",name);
		}
		return new CommonResult().failed();
	}


}

package com.example.springbootwithjpa.control;

import com.example.springbootwithjpa.dao.UserDao;
import com.example.springbootwithjpa.entity.CommonResult;

import com.example.springbootwithjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/10 16:26
 */
@Controller
public class UserController {

	@Autowired
    UserDao userDao;

	@RequestMapping("/hello")
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
	@RequestMapping("/hello/{id}")
	@ResponseBody
	public User hello(@PathVariable("id") Integer id){
		User one = userDao.getOne(id);
		System.out.println(id);
		return one;
	}

	@RequestMapping("/hello/{name}")
	@ResponseBody
	public Object hello(@PathVariable("name") String name){
		User name1 = userDao.findName(name);
		if (name1!=null){
			return new CommonResult().success("查询成功！",name1);
		}else {
			return new CommonResult().failed("无此用户信息！");
		}

	}


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

}

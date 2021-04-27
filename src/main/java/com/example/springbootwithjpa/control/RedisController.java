/*
package com.example.springbootwithjpa.control;

import com.example.springbootwithjpa.configuration.RedisUtil;
import com.example.springbootwithjpa.entity.CommonResult;
import com.example.springbootwithjpa.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/14 16:28
 *//*

@RestController
public class RedisController {

	private static int ExprieTime = 60;//redis设置默认60s

	@Resource
	private RedisUtil redisUtil;

	@RequestMapping("/set/{key}")
	public boolean redisset(@PathVariable("key") String key){

		UserEntity userEntity = new UserEntity();
		userEntity.setId(Long.valueOf(1));
		userEntity.setGuid(String.valueOf(1));
		userEntity.setName("zhangsan");
		userEntity.setAge(String.valueOf(20));
		userEntity.setCreateTime(new Date());

		return redisUtil.set(key,userEntity);

	}


	@RequestMapping("/deleteredis/{key}")
	public Object deleterediskey(@PathVariable("key") String key){
		if (key==null){
			throw new RuntimeException("还没输入key");
		}
		    redisUtil.del(key);
			return new CommonResult().success();

	}


	@RequestMapping("/get/{key}")
	public Object redisget(@PathVariable("key") String key){
		if (redisUtil.get(key)!=null){
			return new CommonResult().success("从redis查询成功！",redisUtil.get(key)) ;
		}
		else {
			return new CommonResult().failed("数据从redis查询失败！");
		}
	}

	@RequestMapping("/expire/{key}")
	public boolean expire(@PathVariable("key") String key){
		return redisUtil.expire(key,ExprieTime);
	}

	@RequestMapping("/hashmap/{key}")
	public boolean hashmap(@PathVariable("key") String key){
		Map<String,Object> map = new HashMap<String,Object>();
		//添加元素
		map.put("201343161", "尚振伟");
		map.put("201343142", "牛建伟");
		map.put("201343133", "刘中林");
		map.put("201343114", "刘     江");
		//在添加元素时，如果出现相同的键，那么后添加的值会覆盖原有键对应的值（value），
		//ppp
		//并且put方法会返回被覆盖的值。
		map.put("201343115", "傻老二");
		map.put("201343096", "李新鹏");
		map.put("201343187", "田成琳");

		return redisUtil.hmset(key,map,ExprieTime);
	}

	@RequestMapping("hmget/{key}")
	public Object hmget(@PathVariable("key") String key){
	 return new CommonResult().success("查询hash的redis成功！",redisUtil.hmget(key));
	}

	@RequestMapping("hdel/{key}")
	public Object hdels(@PathVariable("key") String key){
		String[] arr = {"201343115", "201343096"};
		Long hdel = redisUtil.hdel(key, arr);
		if (hdel>0){
			return new CommonResult().success();
		}else {
			return new CommonResult().failed();
		}

	}

}
*/

package com.example.springbootwithjpa.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootwithjpa.Annotation.PermissionsAnnotation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 17:13
 */
@RestController
@RequestMapping(value = "/permission")
public class permissionControl {

	@RequestMapping(value = "/check",method = RequestMethod.POST)

	//添加这个注解
	@PermissionsAnnotation()
	public JSONObject getGroupList(@RequestBody JSONObject request){
		return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
	}
}

package com.example.springbootwithjpa.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 16:37
 */
@RestController
@RequestMapping("/aop")
public class AspAop {

	@GetMapping(value = "/getTest")
	public JSONObject aopTest(){
		return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
	}

	@PostMapping(value = "/postTest")
	public JSONObject appTest2(@RequestParam("id") String id){
		return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
	}

	@GetMapping("/{name}")
	public String testAop(@PathVariable String name) {
		return "Hello " + name;
	}
}

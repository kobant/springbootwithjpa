package com.example.springbootwithjpa.Aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 17:01
 */
@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {

	// 定义一个切面，括号内写入第1步中自定义注解的路径
	@Pointcut("@annotation(com.example.springbootwithjpa.Annotation.PermissionsAnnotation)")
	private void permissionCheck(){

	}

	@Around("permissionCheck()")
	public Object permissionCheckFirst(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("--------------第一个切入面------------");

		//获取请求参数。
		Object[] objects = proceedingJoinPoint.getArgs();
		Long id = ((JSONObject) objects[0]).getLong("id");
		String name = ((JSONObject) objects[0]).getString("name");

		System.out.println("------id------------:"+id);
		System.out.println("------name------------:"+name);

		// id小于0则抛出非法id的异常
		if (id < 0) {
			return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
		}
		return proceedingJoinPoint.proceed();
	}
}

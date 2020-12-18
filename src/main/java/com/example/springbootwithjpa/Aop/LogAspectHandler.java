package com.example.springbootwithjpa.Aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 17:47
 */
@Aspect
@Component
public class LogAspectHandler {
	/**
	 * 定义一个切面，拦截 com.itcodai.course09.controller 包和子包下的所有方法
	 */
	@Pointcut("execution(* com.example.springbootwithjpa.control..*.*(..))")
	public void pointCut() {}
}

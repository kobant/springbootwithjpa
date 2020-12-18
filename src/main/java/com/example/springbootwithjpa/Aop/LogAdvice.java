package com.example.springbootwithjpa.Aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 14:29
 */
@Aspect
@Component
public class LogAdvice {

	//定义一个切入点：被所有GETMapping注解修饰方法会织入advice
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	private void logAdvicePointcut(){

	}

	// Before表示logAdvice将在目标方法执行前执行
	@Before("logAdvicePointcut()")
	public void logAdvice(){
		// 这里只是一个示例，你可以写任何处理逻辑
		System.out.println("get请求的advice触发了");
	}
}

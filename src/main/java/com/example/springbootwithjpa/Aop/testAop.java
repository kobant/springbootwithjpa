package com.example.springbootwithjpa.Aop;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/21 10:50
 */
@Aspect
@Configuration
public class testAop {
	static final Logger log = LoggerFactory.getLogger(testAop.class);

	/**
	 * @Description: 定义需要拦截的切面
	 * @Pointcut("execution(* com.*.controller.*Controller.*(..))")
	 * @Return: void
	 **/
	@Pointcut("execution(* com.example.springbootwithjpa.control..*.*(..))")
	public void methodArgs() {

	}

	@Around("methodArgs()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result;

		Stopwatch stopwatch = Stopwatch.createStarted();
		result = joinPoint.proceed();
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			// ip地址
			String ipAddr = getRemoteHost(request);
			// 请求路径
			String requestUrl = request.getRequestURL().toString();

			// 获取请求参数进行打印
			Signature signature = joinPoint.getSignature();
			MethodSignature methodSignature = (MethodSignature) signature;


			// 参数名数组
			String[] parameterNames = ((MethodSignature) signature).getParameterNames();
			// 构造参数组集合
			List<Object> argList = new ArrayList<>();
			for (Object arg : joinPoint.getArgs()) {
				// request/response无法使用toJSON
				if (arg instanceof HttpServletRequest) {
					argList.add("request");
				} else if (arg instanceof HttpServletResponse) {
					argList.add("response");
				} else {
					argList.add(JSON.toJSON(arg));
				}
			}

			stopwatch.stop();
			long timeConsuming = stopwatch.elapsed(TimeUnit.MILLISECONDS);

			// 请求结果：{}  不打印
			log.info("请求源IP【{}】 -> 请求URL【{}】\n -> 请求耗时：[{}]毫秒 \n请求参数：{} -> {}",
					ipAddr, requestUrl,
					timeConsuming,
					JSON.toJSON(parameterNames), JSON.toJSON(argList)/*,
                    JSON.toJSON(result)*/);
		} catch (Exception e) {
			log.error("参数获取失败: {}", e.getMessage());
		}

		return result;
	}

	/**
	 * 获取目标主机的ip
	 * @param request
	 * @return
	 */
	private String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.contains("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}

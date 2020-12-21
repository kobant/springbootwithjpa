package com.example.springbootwithjpa.Aop;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 17:47
 */
@Aspect
@Component
@Slf4j
public class LogAspectHandler {
	/**
	 * @Pointcut 注解，用来定义一个切点，即上文中所关注的某件事情的入口，切入点定义了事件触发时机。
	 */

	/**
	 * 定义一个切面，拦截 com.itcodai.course09.controller 包和子包下的所有方法
	 */
	@Pointcut("execution(* com.exampl.springbootwithjpa.control..*.*(..))")
	public void pointCut() {}
	//@Before 注解指定的方法在切面切入目标方法之前执行，可以做一些 Log 处理，也可以做一些信息的统计，比如获取用户的请求 URL 以及用户的 IP 地址等等，这个在做个人站点的时候都能用得到，都是常用的方法
	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint){
		Stopwatch stopwatch = Stopwatch.createStarted();
		log.info("====doBefore方法进入了====");

		//获取签名
		Signature signature = joinPoint.getSignature();

		//获取切入的包名
		String declaringTypeName = signature.getDeclaringTypeName();

		//获取执行的方法名
		String funcName = signature.getName();
		log.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);

		//也可以用来记录一些信息，比如获取请求的 URL 和 IP
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request= attributes.getRequest();
		//获取请求 URL
		String url= request.getRequestURL().toString();
		//获取请求IP
		String ip= request.getRemoteAddr();
		log.info("用户请求的url为：{}，ip地址为：{}", url, ip);

		//JointPoint 对象很有用，可以用它来获取一个签名，利用签名可以获取请求的包名、方法名，包括参数（通过 joinPoint.getArgs() 获取）等。
	}

	/**
	 * 在上面定义的切面方法之后执行该方法
	 * @param joinPoint jointPoint
	 */
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {

		log.info("==== doAfter 方法进入了====");
		Signature signature = joinPoint.getSignature();
		String method = signature.getName();
		log.info("方法{}已经执行完", method);
	}

	/**
	 * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(pointcut = "pointCut()", returning = "result")
	public void doAfterReturning(JoinPoint joinPoint,Object result){

		Signature signature = joinPoint.getSignature();
		String classMethod= signature.getName();
		log.info("方法{}执行完毕，返回参数为：{}", classMethod, result);
		// 实际项目中可以根据业务做具体的返回值增强
		log.info("对返回参数进行业务上的增强：{}", result + "增强版");

		/**
		 * 需要注意的是，在 @AfterReturning 注解 中，属性 returning 的值必须要和参数保持一致，否则会检测不到。
		 * 该方法中的第二个入参就是被切方法的返回值，在 doAfterReturning 方法中可以对返回值进行增强，可以根据业务需要做相应的封装
		 */
	}

	/**
	 * 在上面定义的切面方法执行抛异常时，执行该方法
	 * @param joinPoint jointPoint
	 * @param ex ex
	 */
	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		Signature signature = joinPoint.getSignature();
		String method = signature.getName();
		// 处理异常的逻辑
		log.info("执行方法{}出错，异常为：{}", method, ex);
	}

	/**
	 * 当被切方法执行过程中抛出异常时，会进入 @AfterThrowing 注解的方法中执行，在该方法中可以做一些异常的处理逻辑。
	 * 要注意的是 throwing 属性的值必须要和参数一致，否则会报错。该方法中的第二个入参即为抛出的异常。
	 */
}

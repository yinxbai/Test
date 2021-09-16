package com.txdata.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 运行日志打印切面 针对Controller方法
 * 
 * @author huangmk
 * @since 2018-11-21
 *
 */
@Aspect
@Component
public class WebLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	@Pointcut("execution( * com.txdata..controller.*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void logPointCut() {
	}

	@Before("logPointCut()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("[请求地址] : " + request.getRequestURL().toString() + " [HTTP METHOD] : " + request.getMethod()
				+ " [CLASS_METHOD] : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + " [参数] : " + Arrays.toString(joinPoint.getArgs()));

	}

	@AfterReturning(returning = "ret", pointcut = "logPointCut()") // returning的值和doAfterReturning的参数名一致
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
		logger.debug("返回值 : " + ret);
	}

	@Around("logPointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		// proceed()表示执行所拦截的方法，ob为方法的返回值
		Object ob = pjp.proceed();
		logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
		return ob;
	}
}

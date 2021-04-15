package com.github.hqh.mgm.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class ApiLogAspect {

	@Around("@annotation(apiLog)")
	public Object around(ProceedingJoinPoint point, ApiLog apiLog) throws Throwable {
		return LogAspectUtil.logAround(point);
	}

}

package com.github.hqh.mgm.web.aop;

import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {
    
    @Around("(execution(* com.github.hqh.mgm.web.controller..*.*(..)))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methName = joinPoint.getSignature().getName();

        Object returnVal;
        try {
            returnVal = joinPoint.proceed();
        } catch (MgmException e) {
            log.error("MgmException: method={}, MgmException={}", simpleName + "." + methName, e);
            return new GenericResponse<String>(e.getError());
        } catch (Throwable throwable) {
            log.error("Throwable: method={}, throwable={}", simpleName + "." + methName, throwable);
            return new GenericResponse<String>(MgmErrorCode.SYSTEM_EXCEPTION);
        }
        return returnVal;
    }

}

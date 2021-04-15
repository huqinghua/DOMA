package com.github.hqh.mgm.common.aspect;

import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.log.LogAspectUtil;
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

    @Around(
            "execution(!static com.github.hqh.mgm.common.response.GenericResponse *(..)) && " +
                    "(@within(org.springframework.stereotype.Controller) || " +
                    "@within(org.springframework.web.bind.annotation.RestController))"
    )
    public Object doAround(ProceedingJoinPoint joinPoint) {
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methName = joinPoint.getSignature().getName();

        LogAspectUtil.logParams(joinPoint);

        Object returnVal;
        try {
            returnVal = joinPoint.proceed();

            LogAspectUtil.logResult(returnVal);
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

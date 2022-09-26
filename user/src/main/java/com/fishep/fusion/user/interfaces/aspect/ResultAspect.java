package com.fishep.fusion.user.interfaces.aspect;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResultAspect {

    @Around("@annotation(resultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, ResultHandler resultHandler) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            return new Result<>(400, e.getMessage());
        }
    }

}

package com.flare.rap.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {

    private static final String CLASS_LOG_FORMAT = "Class Name : [";
    private static final String METHOD_LOG_FORMAT = "Method Name : [";

    @Before(
            "(execution(* com.flare.rap.common.exception..*(..))"
                    + " || execution(* com.flare.rap.common.interceptor..*(..))"
                    + " || execution(* com.flare.rap.*.repository..*(..))"
                    + " || execution(* com.flare.rap.*.controller..*(..))"
                    + " || execution(* com.flare.rap.*.service..*(..)))"
                    + " && !@annotation(com.flare.rap.annotation.NoLogging)")
    public void beforeMethod(JoinPoint joinPoint){
        var beforeMethodInfo = new StringBuilder();
        var logInfo =
                beforeMethodInfo.append("before method : ")
                        .append(CLASS_LOG_FORMAT)
                        .append(joinPoint.getSignature().getDeclaringTypeName())
                        .append("], ")
                        .append(METHOD_LOG_FORMAT)
                        .append(joinPoint.getSignature().getName())
                        .append("], ")
                        .append("Data : [")
                        .append(Arrays.toString(joinPoint.getArgs()))
                        .append("]")
                        .toString();
        log.info(logInfo);
    }

    @AfterReturning(
            pointcut =
                    "(execution(* com.flare.rap.common.exception..*(..))"
                    + " || execution(* com.flare.rap.common.interceptor..*(..))"
                    + " || execution(* com.flare.rap.*.repository..*(..))"
                    + " || execution(* com.flare.rap.*.controller..*(..))"
                    + " || execution(* com.flare.rap.*.service..*(..)))"
                    + " && !@annotation(com.flare.rap.annotation.NoLogging)", returning = "result")
    public void afterMethod(JoinPoint joinPoint, Object result){
        var afterMethodInfo = new StringBuilder();
        var logInfo =
                afterMethodInfo.append("after method : ")
                        .append(CLASS_LOG_FORMAT)
                        .append(joinPoint.getSignature().getDeclaringTypeName())
                        .append("], ")
                        .append(METHOD_LOG_FORMAT)
                        .append(joinPoint.getSignature().getName())
                        .append("], ")
                        .append("Data : [")
                        .append(result)
                        .append("]")
                        .toString();
        log.info(logInfo);
    }

    @AfterThrowing(
            pointcut =
                    "(execution(* com.flare.rap.common.exception..*(..))"
                            + " || execution(* com.flare.rap.common.interceptor..*(..))"
                            + " || execution(* com.flare.rap.*.repository..*(..))"
                            + " || execution(* com.flare.rap.*.controller..*(..))"
                            + " || execution(* com.flare.rap.*.service..*(..)))"
                            + " && !@annotation(com.flare.rap.annotation.NoLogging)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        var afterThrowingInfo = new StringBuilder();
        var logInfo =
                afterThrowingInfo.append("after method : ")
                        .append(CLASS_LOG_FORMAT)
                        .append(joinPoint.getSignature().getDeclaringTypeName())
                        .append("], ")
                        .append(METHOD_LOG_FORMAT)
                        .append(joinPoint.getSignature().getName())
                        .append("], ")
                        .append("Exception : [")
                        .append(exceptionToString(ex))
                        .append("]")
                        .toString();
        log.info(logInfo);
    }

    private String exceptionToString(Exception exception) {
        StringWriter errorMessage = new StringWriter();
        exception.printStackTrace(new PrintWriter(errorMessage));
        return errorMessage.toString();
    }
}

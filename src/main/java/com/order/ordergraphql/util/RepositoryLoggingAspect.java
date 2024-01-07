package com.order.ordergraphql.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RepositoryLoggingAspect {

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void withinRepository() {
    }

    @Before("publicMethod() && withinRepository()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Calling {} with params {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }
}

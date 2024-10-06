package com.lakshita.person.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectConfig.class);

    @Before("execution(* com.lakshita.person.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: " + joinPoint.getSignature().getName() + "()");
        logger.debug("Arguments: " + java.util.Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "execution(* com.lakshita.person.service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: " + joinPoint.getSignature().getName() + "()", exception);
    }
}


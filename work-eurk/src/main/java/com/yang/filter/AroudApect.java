package com.yang.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Aspect
public class AroudApect {

    @Pointcut(value = "@annotation(com.yang.filter.MyLog)")
    public void testPoint() {
    }
    @Around(value = "testPoint() && @annotation(myLog)")
    public String test(ProceedingJoinPoint point, MyLog myLog) {
        try {
            Object proceed = point.proceed();
//            ExecutorService
        } catch (Throwable throwable) {
            throwable.getCause();
        }
        return "";
    }
}

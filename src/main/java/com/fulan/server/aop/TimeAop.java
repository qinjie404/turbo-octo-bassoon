package com.fulan.server.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author 13862
 */
@Component
@Aspect
@Slf4j
public class TimeAop {

    /**
     * 切点是com.fulan.server.controller.UserController下的所有方法
     * 第一个*代表返回类型不限
     * 第二个*代表所有方法
     * (..) 代表参数不限
     */
    @Pointcut("execution(public * com.fulan.server.controller.UserController.*(..))")
    public void pointcut() {
    }

    /**
     * 切点是带有@TimeAnnotation注解的方法
     */
    @Pointcut("@annotation(com.fulan.server.aop.TimeAnnotation)")
    public void annotationPointcut() {
    }

    @Before(value = "pointcut()||annotationPointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("<=====================================================");
        log.info("前置通知-------------Before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求来源： =》" + request.getRemoteAddr());
        log.info("请求URL：" + request.getRequestURL().toString());
        log.info("请求方式：" + request.getMethod());
        log.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
        log.info("=====================================================>");
    }

    @Around(value = "annotationPointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        Long start = System.currentTimeMillis();
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("环绕通知-------------Around Start");
        log.info("{}开始执行：{}.{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), signature.getDeclaringTypeName(), signature.getName());
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        log.info("{}执行{}.{}结束", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), signature.getDeclaringTypeName(), signature.getName());
        log.info("用时:{}ms", end - start);
        log.info("环绕通知-------------Around End");
    }

    @After(value = "pointcut()")
    public void after() {
        log.info("-----------------------------------------------------");
        log.info("后置通知-------------After");
        log.info("-----------------------------------------------------");
    }

    @AfterReturning(value = "pointcut()||annotationPointcut()")
    public void afterReturning() {
        log.info("-----------------------------------------------------");
        log.info("最终通知-------------AfterReturning");
        log.info("-----------------------------------------------------");
    }

    @AfterThrowing(value = "pointcut()||annotationPointcut()")
    public void afterThrowing() {
        log.info("-----------------------------------------------------");
        log.info("异常通知-------------AfterThrowing");
        log.info("-----------------------------------------------------");
    }
}

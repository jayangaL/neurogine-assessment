package com.neurogine.demomerchantaop.config;

import com.neurogine.demomerchantaop.model.ApplicationLog;
import com.neurogine.demomerchantaop.aspects.ApplicationLogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;
import java.util.logging.Logger;

@Aspect
@Configuration
@RequiredArgsConstructor
public class ApplicationLoggingAspect {

    private final ApplicationLogService applicationLogService;
    private Logger logger = Logger.getLogger(ApplicationLoggingAspect.class.getName());

    @Pointcut("@annotation(com.neurogine.demomerchantaop.annotation.Log)")
    public void pointcut(){
    }

    @Around("execution(* com.neurogine.demomerchantaop.service.*.*(..))")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try{
            result = point.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        saveLog(point,beginTime);
        return  result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint,long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApplicationLog applicationLog = new ApplicationLog();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        applicationLog.setMethod(className+"."+methodName+"()");
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if(args != null && paramNames != null){
            String params = "";
            for (int i=0;i<args.length;i++){
                params += "  " + paramNames[i] + ": "+ args[i];
            }
            applicationLog.setParams(params);
        }

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        applicationLog.setEndpoint(request.getServletPath());

        applicationLog.setUsername("Sample User");
        applicationLog.setRequestTime(Instant.ofEpochMilli(time).atZone(ZoneId.of("Asia/Kuala_Lumpur")).toLocalDateTime());
        applicationLog.setOperation(request.getMethod());
        applicationLogService.saveApplicationLog(applicationLog);
    }

    @Before("execution(* com.neurogine.demomerchantaop.repository.*.*(..))")
    public void logMethodCall(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        logger.info("Before " + methodName);
    }
}

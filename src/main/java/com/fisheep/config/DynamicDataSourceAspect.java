package com.fisheep.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {
    Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(ChooseDataSource)")
    public void beforeSwitchDataSource(JoinPoint point){
        Class<?> aClass = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();
        try {
            Method method = aClass.getMethod(methodName, parameterTypes);
            if(method.isAnnotationPresent(ChooseDataSource.class)){
                //取出注解里面的数据源名字
                ChooseDataSource annotation = method.getAnnotation(ChooseDataSource.class);
                String dsName = annotation.value();
                DataSourceContextHolder.setDs(dsName);
                logger.info("当前线程："+Thread.currentThread().getName()+"【"+methodName+"】数据源已经切换到【"+dsName+"】");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("@annotation(ChooseDataSource)")
    public void afterMethodCompelete(JoinPoint point){
        DataSourceContextHolder.clear();
        logger.info("当前线程："+Thread.currentThread().getName()+"【数据源清空】");
    }
}

package com.example.testmybatisplus.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * aop的实现的数据源切换<br> * aop切点，实现mapper类找寻，找到所属大本营以后，如db1Aspect(),则会调用<br> * db1()前面之前的操作，进行数据源的切换。

@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceAspect {

    @Pointcut("execution(* com.example.testmybatisplus.mapper.db1..*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* com.example.testmybatisplus.mapper.db2..*.*(..))")
    private void db2Aspect() {
    }

    @Before("db1Aspect()")
    public void db1() {
        log.info("切换到db1 数据源...");
        DataSourceContextHolder.setDbType(DBTypeEnum.db1);
    }

    @Before("db2Aspect()")
    public void db2() {
        log.info("切换到db2 数据源...");
        DataSourceContextHolder.setDbType(DBTypeEnum.db2);
    }
} */
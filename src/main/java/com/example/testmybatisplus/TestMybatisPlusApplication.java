package com.example.testmybatisplus;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://blog.csdn.net/weixin_41835612/article/details/83713862
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan( basePackages={"com.example.testmybatisplus.mapper"})
@RestController
@Api(value = "TestMybatisPlusApplication", description = "交易同步开放接口")
//@ComponentScan(basePackages = {"com.example.testmybatisplus"})
public class TestMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMybatisPlusApplication.class, args);
    }

}

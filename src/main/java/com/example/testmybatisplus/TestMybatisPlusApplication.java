package com.example.testmybatisplus;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.example.testmybatisplus.entity.TbSeller;
import com.example.testmybatisplus.mapper.db1.TbSellerMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan( basePackages={"com.example.testmybatisplus.mapper"})
@RestController
@Api(value = "TestMybatisPlusApplication", description = "交易同步开放接口")
//@ComponentScan(basePackages = {"com.example.testmybatisplus"})
public class TestMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMybatisPlusApplication.class, args);
    }

    @Autowired
    private TbSellerMapper tbSellerMapper;

    @RequestMapping("/test")
    @ApiOperation(value = "查询商家关联的版本", notes = "查询商家关联的版本")
    public void selectBySellerNick() {
        List<TbSeller> tbSellers = tbSellerMapper.selectList(null);
        System.out.println(tbSellers.size());
//        TbSeller tbSeller = tbSellerMapper.selectById(1);
//        Page<TbSeller> page = new Page<>(1,10);
//        IPage<TbSeller> tbSellerIPage = tbSellerMapper.selectBySellerNick(page, "tb_seller",1);
//        System.out.println(tbSellerIPage.getTotal());
    }
}

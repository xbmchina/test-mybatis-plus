package com.example.testmybatisplus.service.impl;

import com.example.testmybatisplus.config.DBTypeEnum;
import com.example.testmybatisplus.config.DataSourceUtil;
import com.example.testmybatisplus.config.multi.DbTxConstants;
import com.example.testmybatisplus.config.multi.MultiTransactional;
import com.example.testmybatisplus.entity.Order;
import com.example.testmybatisplus.entity.User;
import com.example.testmybatisplus.mapper.OrderMapper;
import com.example.testmybatisplus.mapper.UserMapper;
import com.example.testmybatisplus.service.MultiTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class MultiTransactionServiceImpl implements MultiTransactionService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @MultiTransactional(value = {DbTxConstants.DB1_TX, DbTxConstants.DB2_TX})
    public void test() {
        DataSourceUtil.setDataSource(DBTypeEnum.db2);
        Order order = new Order();
        order.setOrderNo("5245345345");
        order.setPrice(new BigDecimal(99.9));
        order.setPaidTime(new Date());
        order.setUserId(3);
        orderMapper.insert(order);
        int i = 1/0;

        DataSourceUtil.setDataSource(DBTypeEnum.db1);
        User user= new User();
        user.setAge(23);
        user.setName("xxx");
        userMapper.insert(user);

        int j = 1/0;
        System.out.println(i);
    }
}

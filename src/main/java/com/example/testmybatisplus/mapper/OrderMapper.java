package com.example.testmybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testmybatisplus.entity.Order;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
public interface OrderMapper extends BaseMapper<Order> {
    @Select("SELECT price from t_order where user_id =#{userId}")
    BigDecimal getPriceByUserId(Integer userId);
}

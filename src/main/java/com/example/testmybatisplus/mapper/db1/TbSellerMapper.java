package com.example.testmybatisplus.mapper.db1;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testmybatisplus.entity.TbSeller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TbSellerMapper extends BaseMapper<TbSeller> {
    IPage<TbSeller> selectBySellerNick(Page<TbSeller> page, @Param("tableName") String tableName, @Param("dataSource") Integer dataSource);
}

package com.example.testmybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testmybatisplus.config.DBTypeEnum;
import com.example.testmybatisplus.config.DataSourceUtil;
import com.example.testmybatisplus.entity.TbSeller;
import com.example.testmybatisplus.mapper.db1.TbSellerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbSellerMapperTest {

    @Autowired
    private TbSellerMapper tbSellerMapper;

    @Test
    public void selectBySellerNick() {
        DataSourceUtil.setDataSource(DBTypeEnum.db1);
        List<TbSeller> tbSellers = tbSellerMapper.selectList(null);
        System.out.println(tbSellers.size());
        Page<TbSeller> page = new Page<>(1,10);
        IPage<TbSeller> tbSellerIPage = tbSellerMapper.selectBySellerNick(page, "tb_seller",1);
        System.out.println(tbSellerIPage.getTotal()+"|"+tbSellerIPage.getRecords().size());
    }
}
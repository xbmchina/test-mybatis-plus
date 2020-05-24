package com.example.testmybatisplus.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceUtil {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceUtil.class);
    //  给该方法设置对应的数据源
    public static void setDataSource(DBTypeEnum dbTypeEnum){
        logger.info("切换到"+dbTypeEnum.getValue()+" 数据源...");
        DataSourceContextHolder.setDbType(dbTypeEnum);
    }

}

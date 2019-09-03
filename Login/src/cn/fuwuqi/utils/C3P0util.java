package cn.fuwuqi.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0util {
    private static DataSource dataSource=new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return dataSource;
    }
}

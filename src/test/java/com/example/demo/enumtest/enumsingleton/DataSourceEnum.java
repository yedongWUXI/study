package com.example.demo.enumtest.enumsingleton;

/**
 * Created by zhangyedong on 2018/1/18.
 *
 * 枚举单例
 */
public enum DataSourceEnum {
    DATASOURCE;
    private DBConnection connection = null;
    DataSourceEnum() {
        connection = new DBConnection();
    }
    public DBConnection getConnection() {
        return connection;
    }
}

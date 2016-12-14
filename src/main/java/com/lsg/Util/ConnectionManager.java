package com.lsg.Util;

import com.lsg.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by tgdsl on 2016/12/13.
 */
public class ConnectionManager {
    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static BasicDataSource dataSource = new BasicDataSource();
    static {
        Properties properties = new Properties();
        try {
            properties.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
            DRIVER=properties.getProperty("jdbc.driver");
            URL=properties.getProperty("jdbc.url");
            USERNAME = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");
        }catch (IOException ioe){
            throw new DataAccessException("加载properties.config失败",ioe);
        }
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxWaitMillis(5000);
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        Connection connection =null;
        try {
            connection=dataSource.getConnection();
        }catch (Exception e){
            throw new DataAccessException("获取数据库连接异常，",e);
        }
        return connection;
    }

}

package com.lsg.Util;

import com.lsg.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by tgdsl on 2016/12/13.
 */
public class DBHelp  {
    private static Logger logger =Logger.getLogger(DBHelp.class);
    public static Connection getConnection(){
        return ConnectionManager.getConnection();
    }
    public static void update(String sql,Object... params)throws DataAccessException {
        try{
            QueryRunner queryRunner= new QueryRunner(ConnectionManager.getDataSource());
            queryRunner.update(sql, params);
            logger.debug("SQL:"+sql);
        }catch (SQLException ex){
            logger.error("执行"+sql+"异常");
        }
    }
    public static <T> T query(String sql, ResultSetHandler<T> handler,Object...params) throws DataAccessException{
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try{
            T t = queryRunner.query(sql,handler,params);
            logger.debug("SQL:"+sql);
            return  t;
        }catch (SQLException e){
            logger.error("执行"+sql+"异常");
            throw new DataAccessException("执行"+sql+"异常",e);
        }
    }
    private static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            }catch (SQLException e){
                logger.error("关闭异常");
                throw new DataAccessException("关闭connection异常",e);
            }
        }
    }
}

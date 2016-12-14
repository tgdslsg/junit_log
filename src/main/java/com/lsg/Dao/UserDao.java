package com.lsg.Dao;

import com.lsg.Entity.User;
import com.lsg.Util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by tgdsl on 2016/12/13.
 */
public class UserDao {

    public void save(User user){
        String sql = "insert into user(username,age,address,tel)values(?,?,?,?)";
        DBHelp.update(sql,user.getUaername(),user.getAge(),user.getAddress(),user.getTel());
    }
    public User findById(Integer id){
        String sql = "select * from user where id =?";
         return DBHelp.query(sql,new BeanHandler<User>(User.class),id);
    }
    public List<User> findAll() {
        String sql = "select * from user";
        return  DBHelp.query(sql, new BeanListHandler<>(User.class));
    }
    public void del(Integer id){
        String sql = "delete user where id =?";
        DBHelp.update(sql,id);
    }

}

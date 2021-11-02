package com.dylan.learnbasic.learnjdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Dylan
 * @Date : 2021/10/31 - 11:19
 * @Description :
 * @Function :
 */
public class JDBCTest01 {

    public static void main(String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }


        Connection connection = null;
        Statement statement= null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sucifitz.top:3306/ds", "root", "mylog");
            // 代表一次Sql的操作
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user");
            List<User> userList = new ArrayList<>();
            while (resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                user.setUserGroup(resultSet.getInt("usergroup"));
                userList.add(user);
            }
            userList.forEach(User::print);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            if (null != resultSet){
                try {
                    resultSet.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (null != statement){
                try {
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (null != connection){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}

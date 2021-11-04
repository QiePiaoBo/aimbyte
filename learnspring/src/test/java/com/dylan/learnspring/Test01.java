package com.dylan.learnspring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dylan
 * @Date : 2021/11/3 - 13:12
 * @Description :
 * @Function :
 */
@SpringBootTest
public class Test01 {

    @Autowired
    DataSource druidDataSource;

    @Test
    void getDataSource(){

        System.out.println(druidDataSource.getClass());
        Connection connection = null;
        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);

    }


}

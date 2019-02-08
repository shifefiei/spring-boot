package com.sff.spring.boot.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Test
    public void testDataSource() throws SQLException {

        System.out.println("dataSource类型：" + dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println("connection连接：" + connection);
        connection.close();
    }
}


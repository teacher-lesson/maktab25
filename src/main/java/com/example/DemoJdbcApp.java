package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbcApp {

    public static void main(String[] args) throws SQLException {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("application-context-base.xml");

        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        DataSource dataSource2 = (DataSource) ctx.getBean("dataSource2");


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` WHERE 1");

        resultSet.next();
        String string = resultSet.getString(2);
        System.out.println(string);

        resultSet.close();
        statement.close();
        connection.close();

    }
}

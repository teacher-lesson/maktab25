package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbcApp {

    public static void main(String[] args) throws SQLException {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("application-context-base.xml");

        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);

        Integer integer = template.queryForObject("SELECT count(*) FROM `students`", Integer.class);

        System.out.println(integer);
    }
}

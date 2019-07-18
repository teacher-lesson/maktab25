package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DemoJdbcApp {

    public static void main(String[] args) throws SQLException {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("application-context-base.xml");

        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);

        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("students");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("id", 7);
        parameter.put("name", "stu56");

        insert.execute(parameter);

    }
}

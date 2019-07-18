package com.example;

import com.example.domin.teacher.Teacher;
import com.example.domin.teacher.dao.TeacherDao;
import com.example.domin.teacher.service.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DemoJdbcApp {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("application-context-base.xml");

        TeacherService teacherService = ctx.getBean(TeacherService.class);

        Teacher teacher = new Teacher();
        teacher.setName("tName3");
        teacher.setSureName("tSame3");

        teacherService.add(teacher);


    }
}

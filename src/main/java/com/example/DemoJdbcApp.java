package com.example;

import com.example.domin.teacher.Teacher;
import com.example.domin.teacher.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DemoJdbcApp {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("application-context-base.xml");

        TeacherService teacherService = ctx.getBean(TeacherService.class);

        Teacher teacher = new Teacher();
        teacher.setName("tName4");
        teacher.setSureName("tSame4");

        teacherService.add(teacher);

        teacherService.changeName("tttt", 1);
//
        Teacher tName4 = teacherService.getByName("tttt");

        System.out.println(tName4);


    }
}

package com.example;

import com.example.domin.teacher.Teacher;
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

        SessionFactory factory = ctx.getBean(SessionFactory.class);
        Session currentSession = factory.openSession();
        Transaction transaction = currentSession.beginTransaction();

        Teacher teacher = new Teacher();
        teacher.setName("TName1");
        teacher.setSureName("TSame1");

        currentSession.persist(teacher);
        transaction.commit();
        currentSession.close();
        factory.close();


    }
}

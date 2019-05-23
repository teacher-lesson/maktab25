package com.example.maktab25;


import com.example.maktab25.model.course.Course;
import com.example.maktab25.model.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        Configuration configure = new Configuration().configure();
        //                .addAnnotatedClass(Teacher.class)

        try (
                SessionFactory factory = configure.buildSessionFactory();
                Session session = factory.openSession()
        ) {
            Teacher teacher = session.get(Teacher.class, 2777L);

            System.out.println(teacher.toString());
        }


    }
}

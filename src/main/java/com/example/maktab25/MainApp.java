package com.example.maktab25;


import com.example.maktab25.model.course.Course;
import com.example.maktab25.model.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class MainApp {

    public static void main(String[] args) {

        Reflections reflections = new Reflections(MainApp.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);

        Configuration configure = new Configuration();

        for (Class<?> aClass : classes) {
            configure.addAnnotatedClass(aClass);
        }

        try (
                SessionFactory factory = configure.buildSessionFactory();
                Session session = factory.openSession()
        ) {
            Teacher teacher1 = new Teacher("Ali1", "1111", 1000D);
            Teacher teacher2 = new Teacher("Ali2", "2222", 4000D);
            Teacher teacher3 = new Teacher("Ali3", "3333", 3000D);
            Teacher teacher4 = new Teacher("Ali4", "4444", 2000D);

            Course course11 = new Course("course11");
            Course course12 = new Course("course12");
            Course course21 = new Course("course21");
            Course course22 = new Course("course22");
            Course course31 = new Course("course31");
            Course course32 = new Course("course32");
            Course course41 = new Course("course41");
            Course course42 = new Course("course42");

            teacher1.addCourse(course11);
            teacher1.addCourse(course12);
            teacher2.addCourse(course21);
            teacher2.addCourse(course22);
            teacher3.addCourse(course31);
            teacher3.addCourse(course32);
            teacher4.addCourse(course41);
            teacher4.addCourse(course42);

            session.persist(course11);
            session.persist(course12);
            session.persist(course21);
            session.persist(course22);
            session.persist(course31);
            session.persist(course32);
            session.persist(course41);
            session.persist(course42);

            session.beginTransaction();

            session.persist(teacher1);
            session.persist(teacher2);
            session.persist(teacher3);
            session.persist(teacher4);

            session.getTransaction().commit();
        }


    }
}

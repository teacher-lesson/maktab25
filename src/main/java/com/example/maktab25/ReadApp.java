package com.example.maktab25;


import com.example.maktab25.model.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class ReadApp {

    public static void main(String[] args) {

        Reflections reflections = new Reflections(ReadApp.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);

        Configuration configure = new Configuration();

        for (Class<?> aClass : classes) {
            configure.addAnnotatedClass(aClass);
        }

        Teacher teacher;
        try (
                SessionFactory factory = configure.buildSessionFactory();
                Session session = factory.openSession()
        ) {

            System.out.println("teacher load!");
            teacher = session.createQuery("from Teacher t join fetch t.courses where t.id=?1", Teacher.class).setParameter(1, 1L).getSingleResult();

            System.out.println("teacher loaded!");

            System.out.println("teacher end!");

        } // session closed


        System.out.println(teacher.getCourses());
    }
}

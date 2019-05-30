package com.example.maktab25;


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
                Session session = factory.getCurrentSession()
        ) {
            session.beginTransaction();


            session.getTransaction().commit();
        }


    }
}

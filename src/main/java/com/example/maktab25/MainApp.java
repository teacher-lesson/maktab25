package com.example.maktab25;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        Configuration configure = new Configuration().configure();
        try (
                SessionFactory factory = configure.buildSessionFactory();
                Session session = factory.getCurrentSession()
        ) {
            session.beginTransaction();


            session.getTransaction().commit();
        }


    }
}

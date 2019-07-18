package com.example.domin.teacher.dao;

import com.example.domin.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao {

    private final SessionFactory sessionFactory;

    public TeacherDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Teacher teacher) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(teacher);

        transaction.commit();

        session.close();

    }


}

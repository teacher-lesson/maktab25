package com.example.domin.teacher.dao;

import com.example.domin.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TeacherDao {

    private final SessionFactory sessionFactory;

    public TeacherDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void create(Teacher teacher) {
        Session session = sessionFactory.openSession();
        session.save(teacher);
        session.close();
    }


}

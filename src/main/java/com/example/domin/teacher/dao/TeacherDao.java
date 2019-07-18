package com.example.domin.teacher.dao;

import com.example.domin.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Repository
public class TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    
    @Transactional
    public void create(Teacher teacher) {
//        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//        Session session = sessionFactory.openSession();
//        session.save(teacher);
//        session.close();

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(teacher);
        entityManager.flush();
        entityManager.close();
    }


}

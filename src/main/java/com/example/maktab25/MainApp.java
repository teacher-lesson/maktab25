package com.example.maktab25;


import com.example.maktab25.model.student.Student;
import com.example.maktab25.model.teacher.Teacher;
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

            Student student3 = new Student("student0");

            Teacher teacher1 = session.find(Teacher.class, 1L);
            Teacher teacher2 = session.find(Teacher.class, 2L);
            Teacher teacher3 = session.find(Teacher.class, 3L);

            student3.addTeacher(teacher1);
            student3.addTeacher(teacher2);
            student3.addTeacher(teacher3);

            session.persist(student3);

            session.getTransaction().commit();
        }


    }
}

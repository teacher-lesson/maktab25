package com.example.maktab25;


import com.example.maktab25.model.course.Course;
import com.example.maktab25.model.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure()
//                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Teacher teacher = new Teacher();

        teacher.setName("ALi");
        teacher.setSalary(10000);
        teacher.setTeacherCode("123456");

        Course course1 = new Course("riazi", teacher);
        Course course2 = new Course("riazi2", teacher);

        teacher.addCourse(course1);
        teacher.addCourse(course2);

        session.beginTransaction();

        session.persist(teacher);

        session.getTransaction().commit();

        session.close();

        factory.close();

    }
}

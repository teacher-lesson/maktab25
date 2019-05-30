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

            Teacher teacher = new Teacher("teacher2");

            Student student1 = session.find(Student.class, 1L);
            Student student2 = session.find(Student.class, 2L);
            Student student3 = session.find(Student.class, 3L);

            teacher.addStudent(student1);
            teacher.addStudent(student2);
            teacher.addStudent(student3);

            session.persist(teacher);



            session.getTransaction().commit();
        }


    }
}

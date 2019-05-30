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

            Teacher teacher = new Teacher("teacher1");

            Student student1 = new Student("stu1");
            Student student2 = new Student("stu2");
            Student student3 = new Student("stu3");
            Student student4 = new Student("stu4");

            teacher.addStudent(student1);
            teacher.addStudent(student2);
            teacher.addStudent(student3);
            teacher.addStudent(student4);

            session.persist(teacher);



            session.getTransaction().commit();
        }


    }
}

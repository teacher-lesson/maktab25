package com.example.maktab25.model.teacher;

import com.example.maktab25.model.course.Course;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String teacherCode;

    private double salary;

    @OneToMany(mappedBy = "teacher",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Course> courses;

    @Transient
    private double salaryDay;

    public Teacher() {
    }

    public Teacher(String name, String teacherCode, double salary) {
        this.name = name;
        this.teacherCode = teacherCode;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public double getSalary() {
        return salary;
    }

    public void addCourse(Course course) {
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }
        this.courses.add(course);
        course.setTeacher(this); // add teacher ref to update fk
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalaryDay() {
        return getSalary() / 30;
    }

    public void setSalaryDay(double salaryDay) {
        this.salaryDay = salaryDay;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherCode='" + teacherCode + '\'' +
                ", salary=" + salary +
                ", salaryDay=" + salaryDay +
                '}';
    }
}

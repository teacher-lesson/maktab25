package com.example.maktab25.model.teacher;

import com.example.maktab25.model.student.Student;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import static com.example.maktab25.model.teacher.Teacher.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Teacher {

    // CONST
    public static final String TABLE_NAME = "teachers";
    public static final String ENTITY_NAME = "Teacher";

    //fields

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

//    @CreationTimestamp // hibernate way , only usable in hibernate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate;

    // many to many
    @ManyToMany
    @JoinTable(name = "teacher_students", // name of middle table
            joinColumns = @JoinColumn(name = "t_id"), // name of fk column to this table in middle table
            inverseJoinColumns = @JoinColumn(name = "s_id") // name of fk column to other side table in middle table
    )
    private Collection<Student> students;

    // constructor


    // require
    public Teacher() {
        // require by hibernate(and jpa)
    }

    // optional
    public Teacher(String name) {
        this.name = name;
    }

    @PrePersist // usable in all orm (hibernate, eclipselink, ...)
    // preUpdate , preRemove, PostPersist, PostUpdate, PostRemove
    public void addCreatedDate(){
        this.createdDate = Instant.now();
    }

    // setter getter

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

    public void addStudent(Student student) {
        if (students == null) {
            this. students = new HashSet<>();
        }
        this.students.add(student);
    }

    // toString

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

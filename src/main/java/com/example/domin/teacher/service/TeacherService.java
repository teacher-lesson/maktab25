package com.example.domin.teacher.service;

import com.example.domin.teacher.Teacher;
import com.example.domin.teacher.dao.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void add(Teacher teacher) {
        teacherRepo.save(teacher);
    }
}

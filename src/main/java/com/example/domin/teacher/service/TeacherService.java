package com.example.domin.teacher.service;

import com.example.domin.teacher.Teacher;
import com.example.domin.teacher.dao.TeacherDao;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherDao teacherDao;

    public TeacherService(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void add(Teacher teacher) {
        teacherDao.create(teacher);
    }
}

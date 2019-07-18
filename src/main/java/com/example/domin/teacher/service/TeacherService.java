package com.example.domin.teacher.service;

import com.example.domin.teacher.Teacher;
import com.example.domin.teacher.dao.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@Transactional
public class TeacherService {

    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void add(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public void remove(Teacher teacher) {
        teacherRepo.delete(teacher);
    }

    public void update(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    @Transactional(readOnly = true)
    public Teacher read(Long id) {
        return teacherRepo.findById(id).get();
    }

    public void remove(Long id) {
        teacherRepo.deleteById(id);
    }

    public Teacher getByName(String name){
        return teacherRepo.getByName(name);
    }


    public void changeName(String name, long id){
        teacherRepo.changeName(name, id);
    }
}

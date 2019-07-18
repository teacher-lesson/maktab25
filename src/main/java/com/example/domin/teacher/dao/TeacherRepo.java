package com.example.domin.teacher.dao;

import com.example.domin.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    
    @Query("select t from Teacher t where t.name=:sname")
    Teacher getByName(@Param("sname") String name);

    @Modifying
    @Query("update Teacher t set t.name=:sname where t.id=:id")
    Teacher changeName(@Param("sname") String name, @Param("id") Long id);
}

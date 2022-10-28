package com.manytomanybidiretional.repository;

import com.manytomanybidiretional.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {

    List<Student> findByNameContaining(String name);
}

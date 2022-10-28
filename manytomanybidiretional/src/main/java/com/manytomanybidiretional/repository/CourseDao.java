package com.manytomanybidiretional.repository;

import com.manytomanybidiretional.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {

    List<Course> findByFeeLessThan(double fee);

}

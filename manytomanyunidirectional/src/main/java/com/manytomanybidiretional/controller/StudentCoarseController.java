package com.manytomanybidiretional.controller;

import com.manytomanybidiretional.entity.Course;
import com.manytomanybidiretional.entity.Student;
import com.manytomanybidiretional.repository.CourseDao;
import com.manytomanybidiretional.repository.StudentDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCoarseController {

    private StudentDao studentDao;

    private CourseDao courseDao;

    public StudentCoarseController(StudentDao studentDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentDao.save(student);
    }


    @GetMapping
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId) {
        return studentDao.findById(studentId).orElse(null);
    }

    @GetMapping("find/{name}")
    public List<Student> getStudentByNameContaining(@PathVariable String name) {
        return studentDao.findByNameContaining(name);
    }


    @GetMapping("/search/{fee}")
    public List<Course> findCourseByFee(@PathVariable double fee) {
        return courseDao.findByFeeLessThan(fee);
    }
}

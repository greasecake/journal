package com.school_journal.controller;

import com.school_journal.dao.StudentDao;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentDao studentDao;

    @Autowired
    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/students")
    public List<Student> selectAllStudents() {
        return studentDao.selectAllStudents();
    }

    @GetMapping(value = "/students", params = "group_id")
    public List<Student> selectStudentsWhereGroupId(@RequestParam Long group_id) {
        return studentDao.selectStudentsWhereGroupId(group_id);
    }

    @GetMapping(value = "/students/{id}")
    public Student selectStudent(@PathVariable Long id) {
        return studentDao.selectStudent(id);
    }

    @PostMapping(value = "/students/add")
    public Student insertStudent(@RequestBody Student student) {
        studentDao.insertStudent(student);
        return student;
    }

    @PatchMapping(value = "/students/{id}")
    public Student insertStudent(@RequestBody Student student, @PathVariable Long id) {
        studentDao.updateStudent(student, id);
        return student;
    }
}

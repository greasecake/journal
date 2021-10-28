package com.school_journal.controller;

import com.school_journal.repository.StudentRepository;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Map<String, String>> selectAllStudents() {
        return studentRepository.selectAllWithGroupName();
    }

    @GetMapping(value = "/students", params = "group_id")
    public List<Student> selectStudentsWhereGroupId(@RequestParam Long group_id) {
        return studentRepository.selectWhereGroupId(group_id);
    }

    @GetMapping(value = "/students/{id}")
    public Student selectStudent(@PathVariable Long id) {
        return studentRepository.selectById(id);
    }

    @PostMapping(value = "/students/add")
    public Student insertStudent(@RequestBody Student student) {
        studentRepository.insert(student);
        return student;
    }

    @PatchMapping(value = "/students/{id}")
    public Student insertStudent(@RequestBody Student student, @PathVariable Long id) {
        studentRepository.updateStudent(student, id);
        return student;
    }
}

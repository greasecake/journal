package com.school_journal.controller;

import com.school_journal.repository.StudentRepository;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> selectAllStudents() {
        return studentRepository.selectAll();
    }

    @GetMapping(params = "group_id")
    public List<Student> selectStudentsWhereGroupId(@RequestParam Long group_id) {
        return studentRepository.selectWhereGroupId(group_id);
    }

    @GetMapping(value = "/{id}")
    public Student selectStudent(@PathVariable Long id) {
        return studentRepository.selectById(id);
    }

    @PatchMapping(value = "/{id}")
    public Student insertStudent(@RequestBody Student student, @PathVariable Long id) {
        studentRepository.updateStudent(student, id);
        return student;
    }

    @PostMapping(value = "/add")
    public Student insertStudent(@RequestBody Student student) {
        studentRepository.insert(student);
        return student;
    }
}

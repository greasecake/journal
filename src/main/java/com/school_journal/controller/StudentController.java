package com.school_journal.controller;

import com.school_journal.model.Group;
import com.school_journal.repository.GroupRepository;
import com.school_journal.repository.StudentRepository;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
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
        studentRepository.update(student, id);
        return student;
    }

    @PostMapping(value = "/add")
    public Student insertStudent(@RequestBody Student student) {
        studentRepository.insert(student);
        return student;
    }
}

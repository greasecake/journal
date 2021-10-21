package com.school_journal.controller;

import com.school_journal.dao.StudentDao;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @GetMapping("/students/${group_id}")
    public List<Student> findWhereGroup(Long group_id) {
        return studentDao.findWhereGroup(group_id);
    }
}

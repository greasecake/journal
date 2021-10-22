package com.school_journal.controller;

import com.school_journal.dao.StudentDao;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/students")
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @GetMapping(value = "/students", params = "group_id")
    public List<Student> selectWhereGroupId(@RequestParam Long group_id) {
        return studentDao.selectWhereGroupId(group_id);
    }
}

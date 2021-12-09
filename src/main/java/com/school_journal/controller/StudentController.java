package com.school_journal.controller;

import com.school_journal.controller.common.AbstractController;
import com.school_journal.entity.StudentEntity;
import com.school_journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentController extends AbstractController<StudentEntity, StudentService> {
    public StudentController(StudentService service) {
        super(service);
    }
}

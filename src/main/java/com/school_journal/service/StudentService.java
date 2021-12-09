package com.school_journal.service;

import com.school_journal.entity.StudentEntity;
import com.school_journal.repository.StudentRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends AbstractService<StudentEntity, StudentRepository> {
    public StudentService(StudentRepository repository) {
        super(repository);
    }
}

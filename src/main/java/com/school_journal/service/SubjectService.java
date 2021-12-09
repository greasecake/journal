package com.school_journal.service;

import com.school_journal.entity.SubjectEntity;
import com.school_journal.repository.SubjectRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends AbstractService<SubjectEntity, SubjectRepository> {
    public SubjectService(SubjectRepository repository) {
        super(repository);
    }
}

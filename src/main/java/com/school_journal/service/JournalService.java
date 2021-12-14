package com.school_journal.service;

import com.school_journal.entity.JournalEntity;
import com.school_journal.entity.StudentEntity;
import com.school_journal.repository.JournalRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService extends AbstractService<JournalEntity, JournalRepository> {
    JournalRepository repository;

    public JournalService(JournalRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<JournalEntity> findAll() {
        return super.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public List<JournalEntity> findAllWithParams(Long studentId) {
        List<JournalEntity> result = new ArrayList<>();
        for (JournalEntity journalEntity : findAll()) {
            if (studentId == null || journalEntity.getStudent().getId().equals(studentId)) {
                result.add(journalEntity);
            }
        }
        return result;
    }

    public List<StudentEntity> findGoodStudents() {
        return repository.findGoodStudents();
    };
}

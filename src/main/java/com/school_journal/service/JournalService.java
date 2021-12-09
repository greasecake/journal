package com.school_journal.service;

import com.school_journal.entity.JournalEntity;
import com.school_journal.repository.JournalRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalService extends AbstractService<JournalEntity, JournalRepository> {
    public JournalService(JournalRepository repository) {
        super(repository);
    }
}

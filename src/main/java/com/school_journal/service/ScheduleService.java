package com.school_journal.service;

import com.school_journal.entity.ScheduleEntity;
import com.school_journal.repository.ScheduleRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends AbstractService<ScheduleEntity, ScheduleRepository> {
    public ScheduleService(ScheduleRepository repository) {
        super(repository);
    }
}

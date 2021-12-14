package com.school_journal.service;

import com.school_journal.entity.JournalEntity;
import com.school_journal.entity.ScheduleEntity;
import com.school_journal.repository.ScheduleRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService extends AbstractService<ScheduleEntity, ScheduleRepository> {
    public ScheduleService(ScheduleRepository repository) {
        super(repository);
    }

    public List<ScheduleEntity> findAllWithParams(Long groupId) {
        List<ScheduleEntity> result = new ArrayList<>();
        for (ScheduleEntity scheduleEntity : super.findAll()) {
            if (scheduleEntity.getGroup().getId().equals(groupId)) {
                result.add(scheduleEntity);
            }
        }
        return result;
    }
}

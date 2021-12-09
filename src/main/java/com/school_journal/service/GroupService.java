package com.school_journal.service;

import com.school_journal.entity.GroupEntity;
import com.school_journal.repository.GroupRepository;
import com.school_journal.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends AbstractService<GroupEntity, GroupRepository> {
    public GroupService(GroupRepository repository) {
        super(repository);
    }
}

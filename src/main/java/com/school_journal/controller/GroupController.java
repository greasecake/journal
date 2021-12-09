package com.school_journal.controller;

import com.school_journal.controller.common.AbstractController;
import com.school_journal.entity.GroupEntity;
import com.school_journal.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/groups")
public class GroupController extends AbstractController<GroupEntity, GroupService> {
    public GroupController(GroupService service) {
        super(service);
    }
}

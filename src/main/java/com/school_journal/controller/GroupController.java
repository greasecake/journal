package com.school_journal.controller;

import com.school_journal.entity.Group;
import com.school_journal.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public List<Group> selectAllGroups() {
        return groupRepository.selectAll();
    }

    @GetMapping(value = "/{id}")
    public Group selectGroup(@PathVariable Long id) {
        return groupRepository.selectById(id);
    }

    @PatchMapping(value = "/{id}")
    public Group insertGroup(@RequestBody Group group, @PathVariable Long id) {
        groupRepository.update(group, id);
        return group;
    }

    @PostMapping(value = "/add")
    public Group addGroup(@RequestBody Group group) {
        groupRepository.insert(group);
        return group;
    }

    @GetMapping("/transaction_test")
    public String testTransaction() {
        return groupRepository.recursiveInsert(0);
    }
}

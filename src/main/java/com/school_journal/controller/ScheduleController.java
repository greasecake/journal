package com.school_journal.controller;

import com.school_journal.entity.ScheduleEntry;
import com.school_journal.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping
    public List<ScheduleEntry> getSchedule() {
        return scheduleRepository.getSchedule();
    }

    @GetMapping("/{groupId}")
    public List<ScheduleEntry> getScheduleByGroupId(@PathVariable Long groupId) {
        return scheduleRepository.getScheduleByGroupId(groupId);
    }
}

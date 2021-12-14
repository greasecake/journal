package com.school_journal.controller;

import com.school_journal.controller.common.AbstractController;
import com.school_journal.entity.JournalEntity;
import com.school_journal.entity.ScheduleEntity;
import com.school_journal.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends AbstractController<ScheduleEntity, ScheduleService> {
    public ScheduleController(ScheduleService service) {
        super(service);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleEntity>> findAllWithParams(
            @RequestParam(name = "group_id", required = false) Long groupId) {
        return ResponseEntity.ok(super.service.findAllWithParams(groupId));
    }
}

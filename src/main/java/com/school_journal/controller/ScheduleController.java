package com.school_journal.controller;

import com.school_journal.controller.common.AbstractController;
import com.school_journal.entity.ScheduleEntity;
import com.school_journal.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends AbstractController<ScheduleEntity, ScheduleService> {
    public ScheduleController(ScheduleService service) {
        super(service);
    }
}

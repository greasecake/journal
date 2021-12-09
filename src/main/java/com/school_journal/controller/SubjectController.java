package com.school_journal.controller;

import com.school_journal.controller.common.AbstractController;
import com.school_journal.entity.SubjectEntity;
import com.school_journal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subjects")
public class SubjectController extends AbstractController<SubjectEntity, SubjectService> {
    public SubjectController(SubjectService service) {
        super(service);
    }
}

package com.school_journal.controller;

import com.school_journal.controller.common.AbstractController;
import com.school_journal.entity.JournalEntity;
import com.school_journal.entity.StudentEntity;
import com.school_journal.service.JournalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/journal")
public class JournalController extends AbstractController<JournalEntity, JournalService> {
    public JournalController(JournalService service) {
        super(service);
    }

    @GetMapping
    public ResponseEntity<List<JournalEntity>> findAllWithParams(
            @RequestParam(name = "student_id", required = false) Long studentId) {
        return ResponseEntity.ok(super.service.findAllWithParams(studentId));
    }

    @GetMapping(value = "/good")
    public ResponseEntity<List<StudentEntity>> findGoodStudents() {
        return ResponseEntity.ok(super.service.findGoodStudents());
    }
}

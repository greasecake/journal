package com.school_journal.controller;

import com.school_journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JournalController {
    private final JournalRepository journalRepository;

    @Autowired
    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @GetMapping(value = "/journal", params = "student_id")
    public List<Map<String, String>> selectGradesByStudentId(@RequestParam("student_id") Long studentId) {
        return journalRepository.selectGradesByStudentId(studentId);
    }

    @GetMapping("/journal/good")
    public List<Map<String, String>> findBStudents() {
        return journalRepository.findBStudents();
    }
}

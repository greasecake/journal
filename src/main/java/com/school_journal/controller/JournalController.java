package com.school_journal.controller;

import com.school_journal.model.Journal;
import com.school_journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("journal")
public class JournalController {
    private final JournalRepository journalRepository;

    @Autowired
    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @GetMapping
    public List<Journal> selectAllGrades() {
        return journalRepository.selectAllGrades();
    }

    @GetMapping(params = "student_id")
    public List<Journal> selectGradesByStudentId(@RequestParam("student_id") Long studentId) {
        return journalRepository.selectGradesByStudentId(studentId);
    }

    @GetMapping("/good")
    public List<Map<String, String>> findGoodStudents() {
        return journalRepository.findGoodStudents();
    }
}

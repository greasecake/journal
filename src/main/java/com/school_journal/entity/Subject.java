package com.school_journal.entity;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "subject")
public class Subject {
    Long id;
    String name;
    Set<JournalEntry> journalEntries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "subject_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

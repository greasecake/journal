package com.school_journal.entity;

import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "subjects")
public class SubjectEntity extends AbstractEntity {
    String name;
    Set<JournalEntity> journalEntries;

    @Column(name = "subject_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

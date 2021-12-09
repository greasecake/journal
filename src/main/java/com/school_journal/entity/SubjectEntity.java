package com.school_journal.entity;

import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "subject")
public class SubjectEntity extends AbstractEntity {
//    Long id;
    String name;
    Set<JournalEntity> journalEntries;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "subject_id")
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }

    @Column(name = "subject_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

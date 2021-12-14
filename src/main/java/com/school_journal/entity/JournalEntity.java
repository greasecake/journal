package com.school_journal.entity;

import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "journal")
public class JournalEntity extends AbstractEntity {
    Date date;
    StudentEntity studentEntity;
    SubjectEntity subjectEntity;
    Integer grade;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public StudentEntity getStudent() {
        return studentEntity;
    }
    public void setStudent(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public SubjectEntity getSubject() {
        return subjectEntity;
    }
    public void setSubject(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}

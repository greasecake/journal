package com.school_journal.entity;

import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "groups")
public class GroupEntity extends AbstractEntity {
    String name;
    List<StudentEntity> students = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "group")
    public List<StudentEntity> getStudents() {
        return students;
    }
    public void setStudents(List<StudentEntity> studentEntities) {
        this.students = studentEntities;
    }

    @Column(name = "group_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

package com.school_journal.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name = "\"group\"")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="groupId")
public class GroupEntity extends AbstractEntity {
    String name;
    Set<StudentEntity> studentEntities = new HashSet<>();

    public GroupEntity() {}

    public GroupEntity(String name) { this.name = name; }

    @Column(name = "group_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    @JsonManagedReference
    public Set<StudentEntity> getStudents() {
        return studentEntities;
    }
    public void setStudents(Set<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}

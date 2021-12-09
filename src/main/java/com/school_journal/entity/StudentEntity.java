package com.school_journal.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;

@Table
@Entity(name = "student")
@JsonIgnoreProperties(value= {"groupEntity"})
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class StudentEntity extends AbstractEntity {
    private String firstName;
    private String lastName;
    private Boolean isHead;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private GroupEntity groupEntity;
    public GroupEntity getGroup() {
        return groupEntity;
    }
    public void setGroup(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    public StudentEntity() {}

    public StudentEntity(String firstName, String lastName, GroupEntity groupEntity, Boolean isHead) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupEntity = groupEntity;
        this.isHead = isHead;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "is_head")
    public Boolean getIsHead() {
        return isHead;
    }
    public void setIsHead(Boolean head) {
        isHead = head;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

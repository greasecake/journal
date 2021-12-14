package com.school_journal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;

@Table
@Entity(name = "students")
public class StudentEntity extends AbstractEntity {
    private String firstName;
    private String lastName;
    private Boolean isHead;
    @JsonIgnoreProperties({"students"})
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    public GroupEntity getGroup() {
        return group;
    }
    public void setGroup(GroupEntity groupEntity) {
        this.group = groupEntity;
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
}

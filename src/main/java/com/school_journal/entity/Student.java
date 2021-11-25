package com.school_journal.entity;

import javax.persistence.*;

@Table
@Entity(name = "student")
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Group group;
    private Boolean isHead;

    public Student() {}

    public Student(String firstName, String lastName, Group group, Boolean isHead) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.isHead = isHead;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Column(name = "is_head")
    public Boolean getIsHead() {
        return isHead;
    }
    public void setIsHead(Boolean head) {
        isHead = head;
    }
}

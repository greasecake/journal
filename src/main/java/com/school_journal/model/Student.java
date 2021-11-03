package com.school_journal.model;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Boolean getIsHead() {
        return isHead;
    }

    public void setIsHead(Boolean head) {
        isHead = head;
    }
}

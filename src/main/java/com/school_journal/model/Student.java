package com.school_journal.model;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Long group_id;
    private Boolean isHead;

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

    public Long getGroupId() {
        return group_id;
    }

    public void setGroupId(Long group_id) {
        this.group_id = group_id;
    }

    public Boolean getIsHead() {
        return isHead;
    }

    public void setIsHead(Boolean head) {
        isHead = head;
    }
}

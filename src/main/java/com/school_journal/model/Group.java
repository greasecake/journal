package com.school_journal.model;

public class Group {
    Long id;
    String name;

    public Group() {}

    public Group(String name) { this.name = name; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

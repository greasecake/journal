package com.school_journal.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name = "group")
public class Group {

    Long id;
    String name;
    Set<Student> students = new HashSet<>();

    public Group() {}

    public Group(String name) { this.name = name; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "group_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

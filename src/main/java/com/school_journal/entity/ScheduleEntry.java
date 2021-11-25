package com.school_journal.entity;

import javax.persistence.*;
import java.sql.Time;

@Table
@Entity(name = "schedule")
public class ScheduleEntry {
    Integer id;
    String dayOfWeek;
    Time time;
    Subject subject;
    Group group;
    Integer roomNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_entry_id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Column(name = "day_of_week")
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    @Column(name = "room_number")
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}

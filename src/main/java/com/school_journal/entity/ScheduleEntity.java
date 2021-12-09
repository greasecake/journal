package com.school_journal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.school_journal.entity.common.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "schedule")
public class ScheduleEntity extends AbstractEntity {
    String dayOfWeek;
    Date time;
    Integer roomNumber;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    SubjectEntity subjectEntity;

    @ManyToOne
    @JoinColumn(name = "group_id")
    GroupEntity groupEntity;

    public SubjectEntity getSubject() {
        return subjectEntity;
    }
    public void setSubject(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public GroupEntity getGroup() {
        return groupEntity;
    }
    public void setGroup(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
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
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
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

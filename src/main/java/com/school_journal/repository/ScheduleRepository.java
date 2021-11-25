package com.school_journal.repository;

import com.school_journal.entity.Group;
import com.school_journal.entity.ScheduleEntry;
import com.school_journal.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<ScheduleEntry> scheduleMapper = (ResultSet rs, int rowNum) -> {
        Group group = new Group();
        group.setId(rs.getLong("group_id"));
        group.setName(rs.getString("group_name"));

        Subject subject = new Subject();
        subject.setId(rs.getLong("subject_id"));
        subject.setName(rs.getString("subject_name"));

        ScheduleEntry scheduleEntry = new ScheduleEntry();
        scheduleEntry.setDayOfWeek(rs.getString("day_of_week"));
        scheduleEntry.setTime(rs.getTime("time"));
        scheduleEntry.setRoomNumber(rs.getInt("room_number"));
        scheduleEntry.setSubject(subject);
        scheduleEntry.setGroup(group);
        return scheduleEntry;
    };

    public List<ScheduleEntry> getSchedule() {
        String SQL = "select * " +
                "from schedule " +
                "join subject " +
                "using (subject_id) " +
                "join \"group\" " +
                "using (group_id) " +
                "order by group_name, day_of_week, time";
        return jdbcTemplate.query(SQL, scheduleMapper);
    }

    public List<ScheduleEntry> getScheduleByGroupId(Long group_id) {
        String SQL = "select * " +
                "from schedule " +
                "join subject " +
                "using (subject_id) " +
                "join \"group\" " +
                "using (group_id) " +
                "where group_id " +
                "order by group_name, day_of_week, time";
        return jdbcTemplate.query(SQL, scheduleMapper, group_id);
    }
}

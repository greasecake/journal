package com.school_journal.repository;

import com.school_journal.model.Group;
import com.school_journal.model.Schedule;
import com.school_journal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Schedule> scheduleMapper = (ResultSet rs, int rowNum) -> {
        Group group = new Group();
        group.setId(rs.getLong("group_id"));
        group.setName(rs.getString("group_name"));

        Subject subject = new Subject();
        subject.setId(rs.getLong("subject_id"));
        subject.setName(rs.getString("subject_name"));

        Schedule schedule = new Schedule();
        schedule.setDayOfWeek(rs.getString("day_of_week"));
        schedule.setTime(rs.getTime("time"));
        schedule.setRoomNumber(rs.getInt("room_number"));
        schedule.setSubject(subject);
        schedule.setGroup(group);
        return schedule;
    };

    public List<Schedule> getSchedule() {
        String SQL = "select * " +
                "from schedule " +
                "join subject " +
                "using (subject_id) " +
                "join \"group\" " +
                "using (group_id) " +
                "order by group_id, day_of_week, time";
        return jdbcTemplate.query(SQL, scheduleMapper);
    }

    public List<Schedule> getScheduleByGroupId(Long group_id) {
        String SQL = "select * " +
                "from schedule " +
                "join subject " +
                "using (subject_id) " +
                "join \"group\" " +
                "using (group_id) " +
                "where group_id " +
                "order by group_id, day_of_week, time";
        return jdbcTemplate.query(SQL, scheduleMapper, group_id);
    }
}

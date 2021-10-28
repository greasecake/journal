package com.school_journal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

    public static class ScheduleExtractor implements ResultSetExtractor<List<Map<String, String>>> {
        @Override
        public List<Map<String, String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Map<String, String>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("День", rs.getString("day_of_week"));
                map.put("Время", rs.getTime("time").toString());
                map.put("Предмет", rs.getString("subject_name"));
                map.put("Кабинет", String.valueOf(rs.getInt("room_number")));
                list.add(map);
            }
            return list;
        }
    }

    public List<Map<String, String>> getSchedule(Long group_id) {
        String SQL = "select " +
                "       day_of_week, " +
                "       time, " +
                "       subject.name as subject_name, " +
                "       room_number " +
                "from schedule " +
                "join subject " +
                "on subject.id = schedule.subject_id " +
                "where group_id = ?" +
                "order by day_of_week, time";
        return jdbcTemplate.query(SQL, new ScheduleExtractor(), group_id);
    }
}

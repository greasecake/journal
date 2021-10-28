package com.school_journal.repository;

import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JournalRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JournalRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class JournalExtractor implements ResultSetExtractor<List<Map<String, String>>> {
        @Override
        public List<Map<String, String>> extractData(ResultSet rs) throws SQLException {
            List<Map<String, String>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("Дата", rs.getDate("date").toString());
                map.put("Предмет", rs.getString("subject_name"));
                map.put("Оценка", rs.getString("grade"));
                list.add(map);
            }
            return list;
        }
    }

    private static class GradesExtractor implements ResultSetExtractor<List<Map<String, String>>> {
        @Override
        public List<Map<String, String>> extractData(ResultSet rs) throws SQLException {
            List<Map<String, String>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put(rs.getString("student_name"), rs.getString("grades"));
                list.add(map);
            }
            return list;
        }
    }

    public List<Map<String, String>> selectGradesByStudentId(Long studentId) {
        String SQL = "select " +
                "       date, " +
                "       subject.name as subject_name, " +
                "       grade " +
                "from journal " +
                "join student " +
                "on journal.student_id = student.id " +
                "join subject " +
                "on journal.subject_id = subject.id " +
                "where student_id = ?";
        return jdbcTemplate.query(SQL, new JournalExtractor(), studentId);
    }

    public List<Map<String, String>> findBStudents() {
        String SQL = "select " +
                "       first_name || ' ' || last_name as student_name, " +
                "       array_to_string(array_agg(grade), ', ') as grades " +
                "from student " +
                "right join journal " +
                "on journal.student_id = student.id " +
                "group by student_id, first_name, last_name " +
                "having min(grade) > 3";
        return jdbcTemplate.query(SQL, new GradesExtractor());
    }
}

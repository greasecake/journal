package com.school_journal.repository;

import com.school_journal.model.Group;
import com.school_journal.model.Journal;
import com.school_journal.model.Student;
import com.school_journal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
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

    private final RowMapper<Journal> journalMapper = (ResultSet rs, int rowNum) -> {
        Group group = new Group();
        group.setId(rs.getLong("group_id"));
        group.setName(rs.getString("group_name"));

        Student student = new Student();
        student.setId(rs.getLong("student_id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setIsHead(rs.getBoolean("is_head"));
        student.setGroup(group);

        Subject subject = new Subject();
        subject.setId(rs.getLong("subject_id"));
        subject.setName(rs.getString("subject_name"));

        Journal journal = new Journal();
        journal.setDate(rs.getDate("date"));
        journal.setGrade(rs.getInt("grade"));
        journal.setStudent(student);
        journal.setSubject(subject);
        return journal;
    };

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


    public List<Journal> selectAllGrades() {
        String SQL = "select * " +
                "from journal " +
                "join student " +
                "using (student_id) " +
                "join subject " +
                "using (subject_id) " +
                "join \"group\" " +
                "using (group_id) " +
                "order by date, student.last_name, student.first_name, subject_name";
        return jdbcTemplate.query(SQL, journalMapper);
    }

    public List<Journal> selectGradesByStudentId(Long studentId) {
        String SQL = "select * " +
                "from journal " +
                "join student " +
                "using (student_id) " +
                "join subject " +
                "using (subject_id) " +
                "join \"group\" " +
                "using (group_id) " +
                "where student_id = ? " +
                "order by date, student.last_name, student.first_name, subject_name";
        return jdbcTemplate.query(SQL, journalMapper, studentId);
    }

    public List<Map<String, String>> findGoodStudents() {
        String SQL = "select " +
                "       first_name || ' ' || last_name as student_name, " +
                "       array_to_string(array_agg(grade), ', ') as grades " +
                "from student " +
                "right join journal " +
                "using (student_id) " +
                "group by student_id, first_name, last_name " +
                "having min(grade) > 3";
        return jdbcTemplate.query(SQL, new GradesExtractor());
    }
}

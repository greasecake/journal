package com.school_journal.dao;

import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setGroupId(resultSet.getLong("group_id"));
            student.setHead(resultSet.getBoolean("is_head"));
            return student;
        }
    }

    public List<Student> findAll() {
        return jdbcTemplate.query(
                "select first_name || ' ' || last_name from students",
                new StudentMapper());
    }

    public List<Student> findWhereGroup(Long group_id) {
        return jdbcTemplate.query(
                "select first_name || ' ' || last_name from students where group_id = ?",
                new StudentMapper(),
                group_id);
    }
}

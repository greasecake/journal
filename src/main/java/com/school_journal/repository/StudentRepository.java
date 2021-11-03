package com.school_journal.repository;

import com.school_journal.model.Group;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.*;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> studentMapper = (ResultSet rs, int rowNum) -> {
        Group group = new Group();
        group.setId(rs.getLong("group_id"));
        group.setName(rs.getString("group_name"));

        Student student = new Student();
        student.setId(rs.getLong("student_id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setIsHead(rs.getBoolean("is_head"));
        student.setGroup(group);
        return student;
    };

    @Transactional
    public List<Student> selectAll() {
        String SQL = "select * " +
                "from student " +
                "join \"group\" " +
                "using (group_id)";
        return jdbcTemplate.query(SQL, studentMapper);
    }

    public List<Student> selectWhereGroupId(Long group_id) {
        String SQL = "select * " +
                "from ( " +
                "    select * from \"group\" where group_id = ?) g " +
                "join student " +
                "using (group_id)";
        return jdbcTemplate.query(SQL, studentMapper, group_id);
    }

    public Student selectById(Long student_id) {
        String SQL = "select * " +
                "from ( " +
                "    select * from student where student_id = ?) s " +
                "join \"group\" " +
                "using (group_id)";
        return jdbcTemplate.queryForObject(SQL, studentMapper, student_id);
    }

    public int insert(Student student) {
        String SQL = "insert into student " +
                "(first_name, last_name, group_id, is_head) " +
                "values (?, ?, ?, ?)";
        return jdbcTemplate.update(SQL,
                student.getFirstName(),
                student.getLastName(),
                student.getGroup().getId(),
                student.getIsHead());
    }

    public int update(Student student, Long student_id) {
        String SQL = "update student new " +
                "set " +
                "    first_name = coalesce(?, old.first_name), " +
                "    last_name = coalesce(?, old.last_name), " +
                "    group_id = coalesce(?, old.group_id), " +
                "    is_head = coalesce(?, old.is_head) " +
                "from student old " +
                "where new.student_id = ?";
        return jdbcTemplate.update(SQL,
                    student.getFirstName(), 
                    student.getLastName(), 
                    student.getGroup().getId(), 
                    student.getIsHead(),
                student_id);
    }
}
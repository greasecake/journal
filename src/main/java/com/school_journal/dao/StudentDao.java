package com.school_journal.dao;

import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Student> StudentMapper = (ResultSet resultSet, int rowNum) -> {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setLastName(resultSet.getString("last_name"));
        student.setGroupId(resultSet.getLong("group_id"));
        student.setIsHead(resultSet.getBoolean("is_head"));
        return student;
    };

//    public static class StudentWithDetailExtractor implements ResultSetExtractor<List<Student>> {
//        @Override
//        public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
//            Map<Long, Student> map = new HashMap<>();
//            Student student;
//            while (rs.next()) {
//                Long id = rs.getLong("id");
//                student = map.get(id);
//                if (student == null) {
//                    map.put(id, )
//                }
//            }
//        }
//    }

    public List<Student> selectAllStudents() {
        String SQL = "select * from student";
        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Student.class));
    }

    public List<Student> selectStudentsWhereGroupId(Long group_id) {
        String SQL = "select * from student where group_id = ?";
        return jdbcTemplate.query(SQL, StudentMapper, group_id);
    }

    public Student selectStudent(Long id) {
        String SQL = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(SQL, StudentMapper, id);
    }

    public int insertStudent(Student student) {
        String SQL = "insert into student (first_name, last_name, group_id, is_head) values (?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, student.getFirstName(), student.getLastName(), student.getGroupId(), student.getIsHead());
    }

    public int updateStudent(Student student, Long id) {
        String SQL = "update student new " +
                "set " +
                "    first_name = coalesce(?, old.first_name), " +
                "    last_name = coalesce(?, old.last_name), " +
                "    group_id = coalesce(?, old.group_id), " +
                "    is_head = coalesce(?, old.is_head) " +
                "from student old " +
                "where new.id = ?";
        return jdbcTemplate.update(SQL, student.getFirstName(), student.getLastName(), student.getGroupId(), student.getIsHead(), id);
    }
}
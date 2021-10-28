package com.school_journal.repository;

import com.school_journal.model.Group;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Student> studentMapper = (ResultSet resultSet, int rowNum) -> {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setLastName(resultSet.getString("last_name"));
        student.setGroupId(resultSet.getLong("group_id"));
        student.setIsHead(resultSet.getBoolean("is_head"));
        return student;
    };

    public static class StudentExtractor implements ResultSetExtractor<List<Map<String, String>>> {
        @Override
        public List<Map<String, String>> extractData(ResultSet rs) throws SQLException {
            List<Map<String, String>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("Имя", rs.getString("first_name"));
                map.put("Фамилия", rs.getString("last_name"));
                map.put("Староста", rs.getBoolean("is_head") ? "Да" : "Нет");
                map.put("Группа", rs.getString("name"));
                list.add(map);
            }
            return list;
        }
    }

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

    public List<Student> selectAll() {
        String SQL = "select * from student";
        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Student.class));
    }

    public List<Map<String, String>> selectAllWithGroupName() {
        String SQL = "select\n" +
                "       student.id,\n" +
                "       first_name,\n" +
                "       last_name,\n" +
                "       is_head,\n" +
                "       group_id,\n" +
                "       \"name\"\n" +
                "from student\n" +
                "join \"group\"\n" +
                "on student.group_id = \"group\".id";
        return jdbcTemplate.query(SQL, new StudentExtractor());
    }

    public List<Student> selectWhereGroupId(Long group_id) {
        String SQL = "select * from student where group_id = ?";
        return jdbcTemplate.query(SQL, studentMapper, group_id);
    }

    public Student selectById(Long id) {
        String SQL = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(SQL, studentMapper, id);
    }

    public int insert(Student student) {
        String SQL = "insert into student (first_name, last_name, group_id, is_head) values (?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, student.getFirstName(), student.getLastName(), student.getGroup().getId(), student.getIsHead());
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
        return jdbcTemplate.update(SQL, student.getFirstName(), student.getLastName(), student.getGroup().getId(), student.getIsHead(), id);
    }
}
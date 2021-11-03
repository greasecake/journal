package com.school_journal.repository;

import com.school_journal.model.Group;
import com.school_journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class GroupRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Group> groupMapper = (ResultSet rs, int rowNum) -> {
        Group group = new Group();
        group.setId(rs.getLong("group_id"));
        group.setName(rs.getString("group_name"));   
        return group;
    };

    @Autowired
    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Group> selectAll() {
        String SQL = "select * from \"group\"";
        return jdbcTemplate.query(SQL, groupMapper);
    }

    public Group selectById(Long group_id) {
        String SQL = "select * from \"group\" where group_id = ?";
        return jdbcTemplate.queryForObject(SQL, groupMapper, group_id);
    }

    public int insert(Group group) {
        String SQL = "insert into \"group\" (group_name) values (?)";
        return jdbcTemplate.update(SQL, group.getName());
    }

    public int update(Group group, Long group_id) {
        String SQL = "update \"group\" set group_name = ? where group_id = ?";
        return jdbcTemplate.update(SQL, group.getName(), group_id);
    }
}
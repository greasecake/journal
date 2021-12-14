package com.school_journal.repository;

import com.school_journal.entity.JournalEntity;
import com.school_journal.entity.StudentEntity;
import com.school_journal.repository.common.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends CommonRepository<JournalEntity> {
    @Query(value =
                    "select s " +
                    "from students s " +
                    "join journal j " +
                    "on s.id = j.student.id " +
                    "group by s " +
                    "having min(j.grade) > 3 ")
    List<StudentEntity> findGoodStudents();
}

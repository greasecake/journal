package com.school_journal.repository;

import com.school_journal.entity.StudentEntity;
import com.school_journal.repository.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CommonRepository<StudentEntity> {
}

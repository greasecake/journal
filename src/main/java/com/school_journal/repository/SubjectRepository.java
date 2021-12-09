package com.school_journal.repository;

import com.school_journal.entity.SubjectEntity;
import com.school_journal.repository.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CommonRepository<SubjectEntity> {
}

package com.school_journal.repository;

import com.school_journal.entity.JournalEntity;
import com.school_journal.repository.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends CommonRepository<JournalEntity> {
}

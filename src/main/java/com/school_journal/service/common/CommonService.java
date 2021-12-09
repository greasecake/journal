package com.school_journal.service.common;

import com.school_journal.entity.common.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {
    Optional<E> findById(Long id);

    List<E> findAll();

    Optional<E> save(E entity);

    boolean delete(E entity);

    boolean deleteById(Long id);
}

package com.school_journal.service.common;

import com.school_journal.entity.common.AbstractEntity;
import com.school_journal.repository.common.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> implements CommonService<E> {
    private final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        List<E> entities = new ArrayList<>();
        repository.findAll().forEach(entities::add);
        return entities;
    }

    @Override
    public Optional<E> save(E entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public boolean delete(E entity) {
        repository.delete(entity);
        return repository.findById(entity.getId()).isEmpty();
    }

    @Override
    public boolean deleteById(Long id) {
        E entity = findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.delete(entity);
        return repository.findById(entity.getId()).isEmpty();
    }
}

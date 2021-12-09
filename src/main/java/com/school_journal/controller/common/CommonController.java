package com.school_journal.controller.common;

import com.school_journal.entity.common.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {
    @GetMapping(value = "/{id}")
    ResponseEntity<E> findById(Long id);

    @GetMapping
    ResponseEntity<List<E>> findAll();

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

    @PutMapping
    ResponseEntity<E> update(@RequestBody E entity);

    @DeleteMapping(value = "/{id}")
    Boolean deleteById(@PathVariable Long id);
}

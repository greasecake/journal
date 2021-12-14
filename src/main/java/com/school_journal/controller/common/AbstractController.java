package com.school_journal.controller.common;

import com.school_journal.entity.common.AbstractEntity;
import com.school_journal.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> implements CommonController<E> {
    public final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @Override
    @GetMapping(value = "/all")
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<E> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    @PutMapping
    public ResponseEntity<E> save(@RequestBody E entity) {
        return service.save(entity).map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("Not saved"));
    }

    @Override
    @PostMapping
    public ResponseEntity<E> update(@RequestBody E entity) {
        return service.save(entity).map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("Not updated"));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public Boolean deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}

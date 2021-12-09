package com.school_journal.repository.common;

import com.school_journal.entity.common.AbstractEntity;
import org.hibernate.SessionFactory;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;

public abstract class AbstractRepository<T extends AbstractEntity> implements CrudRepository {
    Class<T> aClass;

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;
    

}

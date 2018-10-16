package com.api.rest.rest_tutorial.repository;

import org.bson.types.ObjectId;
import java.util.List;


public interface Repository<T> {

    T findBy_id(ObjectId _id);

    <T> List<T> findAll();

    <S extends T> S save(S entity);

    void delete(T entity);
}


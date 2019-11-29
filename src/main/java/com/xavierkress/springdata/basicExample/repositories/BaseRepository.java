package com.xavierkress.springdata.basicExample.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
    Iterable<T> findAll(Pageable sort);
    <S extends T> S save(S entity);
    <S extends T> S save(Iterable<S> entities);
}

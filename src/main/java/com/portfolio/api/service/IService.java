package com.portfolio.api.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface IService<T, E> {

    
    List<T> findAll();
    
    T add(E entity);

    T update(Integer id, E entity) throws NotFoundException;

    T delete(Integer id) throws NotFoundException;

    T findById(Integer id) throws NotFoundException;


}

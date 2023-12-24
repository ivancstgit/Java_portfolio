package com.portfolio.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface IService<T, E> {

    
    List<T> findAll() throws IOException;
    
    T add(E entity) throws IOException;

    T update(Integer id, E entity) throws NotFoundException, IOException;

    T delete(Integer id) throws NotFoundException;

    T findById(Integer id) throws NotFoundException;


}

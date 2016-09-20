package br.com.estudo.agenda.interfaces.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface GenericService<T> {

    T find(Long id);

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> listAll();
}

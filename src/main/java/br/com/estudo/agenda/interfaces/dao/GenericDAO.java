package br.com.estudo.agenda.interfaces.dao;

import java.util.List;

public interface GenericDAO<T> {

    public Class<T> getObjectClass();

    T find(Long id);

    void saveOrUpdate(T entity);

    void delete(T entity);

    List<T> list();

}

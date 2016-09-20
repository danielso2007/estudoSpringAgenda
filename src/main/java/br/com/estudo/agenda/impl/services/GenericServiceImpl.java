package br.com.estudo.agenda.impl.services;

import br.com.estudo.agenda.interfaces.dao.GenericDAO;
import br.com.estudo.agenda.interfaces.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericServiceImpl<T, DAO extends GenericDAO<T>> implements GenericService<T> {
	
	private DAO dao;
	
	public GenericServiceImpl(DAO dao) {
		this.dao = dao;
	}

	@Override
	public T find(Long id) {
		return this.dao.find(id);
	}

	public void save(T entity) {
		dao.saveOrUpdate(entity);
		
	}

	public void update(T entity) {
		dao.saveOrUpdate(entity);
		
	}

	public void delete(T entity) {
		dao.delete(entity);
		
	}

	public List<T> listAll() {
		List<T> list = dao.list();
		return list;
	}
	
}

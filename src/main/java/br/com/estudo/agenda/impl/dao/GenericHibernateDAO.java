package br.com.estudo.agenda.impl.dao;

import br.com.estudo.agenda.interfaces.dao.GenericDAO;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class GenericHibernateDAO<T> implements GenericDAO<T> {

    private Logger logger = Logger.getLogger(GenericHibernateDAO.class);
    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericHibernateDAO() {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } else {
            persistentClass = (Class<T>) getClass().getGenericSuperclass();
        }
    }

    @Override
    public Class<T> getObjectClass() {
        return this.persistentClass;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T find(Long id) {
        return getCurrentSession().find(persistentClass, id);
    }

    public void saveOrUpdate(T entity) {
        try {
            getCurrentSession().saveOrUpdate(entity);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void delete(T entity) {
        try {
            getCurrentSession().delete(entity);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public List<T> list() {
        try {
            Criteria criteria = getCurrentSession().createCriteria(persistentClass);
            return criteria.list();
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
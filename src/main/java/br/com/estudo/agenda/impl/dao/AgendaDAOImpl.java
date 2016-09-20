package br.com.estudo.agenda.impl.dao;

import org.springframework.stereotype.Repository;

import br.com.estudo.agenda.interfaces.dao.AgendaDAO;
import br.com.estudo.agenda.model.domain.Agenda;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AgendaDAOImpl extends GenericHibernateDAO<Agenda> implements AgendaDAO {

}

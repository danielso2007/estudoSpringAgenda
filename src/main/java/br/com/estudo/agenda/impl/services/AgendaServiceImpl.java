package br.com.estudo.agenda.impl.services;

import br.com.estudo.agenda.interfaces.dao.AgendaDAO;
import br.com.estudo.agenda.interfaces.services.AgendaService;
import br.com.estudo.agenda.model.domain.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AgendaServiceImpl extends GenericServiceImpl<Agenda, AgendaDAO> implements AgendaService {

	@Autowired
	public AgendaServiceImpl(AgendaDAO agendaDAO) {
		super(agendaDAO);
	}

}

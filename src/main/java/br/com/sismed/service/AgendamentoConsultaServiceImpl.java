package br.com.sismed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sismed.dao.AgendamentoConsultaDAO;
import br.com.sismed.model.agendamento.AgendamentoConsulta;

@Service
public class AgendamentoConsultaServiceImpl implements AgendamentoConsultaService {
	private AgendamentoConsultaDAO agendamentoConsultaDAO;
	
	public void setAgendamentoConsultaDAO(AgendamentoConsultaDAO agendamentoConsultaDAO) {
		this.agendamentoConsultaDAO = agendamentoConsultaDAO;
	}
	
	@Override
	@Transactional
	public void addAgendamentoConsulta(AgendamentoConsulta ac) {
		this.agendamentoConsultaDAO.addAgendamentoConsulta(ac);

	}

	@Override
	@Transactional
	public void updateAgendamentoConsulta(AgendamentoConsulta ac) {
		this.agendamentoConsultaDAO.updateAgendamentoConsulta(ac);

	}

	@Override
	@Transactional
	public List<AgendamentoConsulta> listAgendamentoConsulta() {
		return this.agendamentoConsultaDAO.listAgendamentoConsulta();
	}

	@Override
	@Transactional
	public AgendamentoConsulta getAgendamentoConsultaById(int id) {
		return this.agendamentoConsultaDAO.getAgendamentoConsultaById(id);
	}

	@Override
	@Transactional
	public void removeAgendamentoConsulta(int id) {
		this.agendamentoConsultaDAO.removeAgendamentoConsulta(id);

	}

}

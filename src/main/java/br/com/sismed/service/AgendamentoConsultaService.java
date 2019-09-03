package br.com.sismed.service;

import java.util.List;

import br.com.sismed.model.agendamento.AgendamentoConsulta;

public interface AgendamentoConsultaService {
	public void addAgendamentoConsulta(AgendamentoConsulta ac);
	public void updateAgendamentoConsulta(AgendamentoConsulta ac);
	public List<AgendamentoConsulta> listAgendamentoConsulta();
	public AgendamentoConsulta getAgendamentoConsultaById(int id);
	public void removeAgendamentoConsulta(int id);

}

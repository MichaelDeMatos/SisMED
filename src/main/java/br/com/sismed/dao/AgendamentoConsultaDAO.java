package br.com.sismed.dao;

import java.util.List;

import br.com.sismed.model.agendamento.AgendamentoConsulta;

public interface AgendamentoConsultaDAO {
	public void addAgendamentoConsulta(AgendamentoConsulta ac);
	public void updateAgendamentoConsulta(AgendamentoConsulta ac);
	public List<AgendamentoConsulta> listAgendamentoConsulta();
	public AgendamentoConsulta getAgendamentoConsultaById(int id);
	public void removeAgendamentoConsulta(int id);
}

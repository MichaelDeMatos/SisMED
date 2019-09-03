package br.com.sismed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sismed.dao.PacienteDAO;
import br.com.sismed.model.pessoa.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {
	private PacienteDAO pacienteDAO;
	
	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}
	
	@Override
	@Transactional
	public void addPaciente(Paciente p) {
		this.pacienteDAO.addPaciente(p);

	}

	@Override
	@Transactional
	public void updatePaciente(Paciente p) {
		this.pacienteDAO.updatePaciente(p);
	}

	@Override
	@Transactional
	public List<Paciente> listPaciente() {
		return this.pacienteDAO.listPaciente();
	}

	@Override
	@Transactional
	public Paciente getPacienteById(int id) {
		return this.pacienteDAO.getPacienteById(id);
	}

	@Override
	@Transactional
	public void removePaciente(int id) {
		this.pacienteDAO.removePaciente(id);

	}

}

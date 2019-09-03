package br.com.sismed.service;

import java.util.List;

import br.com.sismed.model.pessoa.Paciente;

public interface PacienteService {
	public void addPaciente(Paciente p);
	public void updatePaciente(Paciente p);
	public List<Paciente> listPaciente();
	public Paciente getPacienteById(int id);
	public void removePaciente(int id);
}

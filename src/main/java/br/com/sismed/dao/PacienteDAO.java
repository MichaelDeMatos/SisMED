package br.com.sismed.dao;

import java.util.List;

import br.com.sismed.model.pessoa.Paciente;

public interface PacienteDAO {
	public void addPaciente(Paciente p);
	public void updatePaciente(Paciente p);
	public List<Paciente> listPaciente();
	public Paciente getPacienteById(int id);
	public void removePaciente(int id);

}

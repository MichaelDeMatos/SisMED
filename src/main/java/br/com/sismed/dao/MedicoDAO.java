package br.com.sismed.dao;

import java.util.List;

import br.com.sismed.model.pessoa.Medico;

public interface MedicoDAO {
	public void addMedico(Medico m);
	public void updateMedico(Medico m);
	public List<Medico> listMedico();
	public Medico getMedicoById(int id);
	public void removeMedico(int id);

}

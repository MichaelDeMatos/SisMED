package br.com.sismed.service;

import java.util.List;

import br.com.sismed.model.pessoa.Medico;

public interface MedicoService {
	public void addMedico(Medico m);
	public void updateMedico(Medico m);
	public List<Medico> listMedico();
	public Medico getMedicoById(int id);
	public void removeMedico(int id);

}

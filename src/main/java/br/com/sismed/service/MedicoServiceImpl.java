package br.com.sismed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sismed.dao.MedicoDAO;
import br.com.sismed.model.pessoa.Medico;

@Service
public class MedicoServiceImpl implements MedicoService {
	private MedicoDAO medicoDAO;
	
	public void setMedicoDAO(MedicoDAO medicoDAO) {
		this.medicoDAO = medicoDAO;
	}

	@Override
	@Transactional
	public void addMedico(Medico m) {
		this.medicoDAO.addMedico(m);

	}

	@Override
	@Transactional
	public void updateMedico(Medico m) {
		this.medicoDAO.updateMedico(m);

	}

	@Override
	@Transactional
	public List<Medico> listMedico() {
		return this.medicoDAO.listMedico();
	}

	@Override
	@Transactional
	public Medico getMedicoById(int id) {
		return this.medicoDAO.getMedicoById(id);
	}

	@Override
	@Transactional
	public void removeMedico(int id) {
		this.medicoDAO.removeMedico(id);

	}

}

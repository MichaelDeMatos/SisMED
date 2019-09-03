package br.com.sismed.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.sismed.model.pessoa.Paciente;

public class PacienteDAOImpl implements PacienteDAO{
	private static final Logger logger = LoggerFactory.getLogger(PacienteDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPaciente(Paciente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Paciente salvo ="+p);
		
	}

	@Override
	public void updatePaciente(Paciente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Paciente atualizado="+p);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> listPaciente() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Paciente> pacienteList = session.createQuery("from Paciente").list();
		for(Paciente p : pacienteList){
			logger.info("Paciente List::"+p);
		}
		return pacienteList;
	}

	@Override
	public Paciente getPacienteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Paciente p = (Paciente) session.load(Paciente.class, new Integer(id));
		logger.info("Paciente carregado="+p);
		return p;
	}

	@Override
	public void removePaciente(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Paciente p = (Paciente) session.load(Paciente.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Paciente deletado="+p);
		
	}

}

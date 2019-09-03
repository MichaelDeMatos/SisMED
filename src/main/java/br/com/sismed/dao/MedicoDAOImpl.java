package br.com.sismed.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.sismed.model.pessoa.Medico;

@Repository
public class MedicoDAOImpl implements MedicoDAO {
	private static final Logger logger = LoggerFactory.getLogger(MedicoDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addMedico(Medico m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
		logger.info("Medico salvo ="+m);
	}

	@Override
	public void updateMedico(Medico m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(m);
		logger.info("Medico atualizado="+m);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> listMedico() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Medico> medicoList = session.createQuery("from Medico").list();
		for(Medico m : medicoList){
			logger.info("Medico List::"+m);
		}
		return medicoList;
	}

	@Override
	public Medico getMedicoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Medico m = (Medico) session.load(Medico.class, new Integer(id));
		logger.info("Medico carregado="+m);
		return m;
	}

	@Override
	public void removeMedico(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Medico m = (Medico) session.load(Medico.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Medico deletado="+m);

	}

}

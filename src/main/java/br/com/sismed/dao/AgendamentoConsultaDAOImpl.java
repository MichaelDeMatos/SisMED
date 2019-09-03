package br.com.sismed.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.sismed.model.agendamento.AgendamentoConsulta;

public class AgendamentoConsultaDAOImpl implements AgendamentoConsultaDAO {
	private static final Logger logger = LoggerFactory.getLogger(AgendamentoConsultaDAOImpl.class);
	
	private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}

	@Override
	public void addAgendamentoConsulta(AgendamentoConsulta ac) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ac);
		logger.info("AgendamentoConsulta salvo ="+ac);
		

	}

	@Override
	public void updateAgendamentoConsulta(AgendamentoConsulta ac) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ac);
		logger.info("AgendamentoConsulta="+ac);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AgendamentoConsulta> listAgendamentoConsulta() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AgendamentoConsulta> agendamentoConsultaList = session.createQuery("from AgendamentoConsulta").list();
		for(AgendamentoConsulta ac : agendamentoConsultaList){
			logger.info("AgendamentoConsulta List::"+ac);
		}
		return agendamentoConsultaList;
	}

	@Override
	public AgendamentoConsulta getAgendamentoConsultaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		AgendamentoConsulta ac = (AgendamentoConsulta) session.load(AgendamentoConsulta.class, new Integer(id));
		logger.info("AgendamentoConsulta carregado="+ac);
		return ac;
	}

	@Override
	public void removeAgendamentoConsulta(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AgendamentoConsulta ac = (AgendamentoConsulta) session.load(AgendamentoConsulta.class, new Integer(id));
		if(null != ac){
			session.delete(ac);
		}
		logger.info("AgendamentoConsulta deletado="+ac);

	}

}

package br.com.sismed.model.agendamento;

import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sismed.model.pessoa.Medico;
import br.com.sismed.model.pessoa.Paciente;

@Entity
@Table(name="AGENDAMENTO")
public class AgendamentoConsulta {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//private Medico medico;
	//private Paciente paciente;
	private Calendar dataAgendada;
	private Time horaInicio;
	private Time horaFim;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Calendar getDataAgendada() {
		return dataAgendada;
	}
	public void setDataAgendada(Calendar dataAgendada) {
		this.dataAgendada = dataAgendada;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}
	
	
	

}

package br.com.sismed.model.pessoa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MEDICO")
public class Medico extends Pessoa{
	
	
	private String especialidade;
	private String CRM;


	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getCRM() {
		return CRM;
	}
	public void setCRM(String cRM) {
		this.CRM = cRM;
	}
	
	

	

}

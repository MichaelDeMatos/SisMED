package br.com.sismed.model.pessoa;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String sexo;
	private String rg;
    private String cpf;
    private String telefone;
    private Calendar dataNascimento;
    private String profissao;
	private int idade;
    
 
     
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
         this.nome = nome;
    }
     

	public String getCpf() {
         return cpf;
    }
     
    public void setCpf(String cpf) {
         this.cpf = cpf;
    }
     
    public String getTelefone() {
         return telefone;
    }
     
    public void setTelefone(String telefone) {
         this.telefone = telefone;
    }
     
     
    public String getRg() {
         return rg;
    }
 
    public void setRg(String rg) {
         this.rg = rg;
    }
 

    public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProfissao() {
         return profissao;
    }
 
    public void setProfissao(String profissao) {
         this.profissao = profissao;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}

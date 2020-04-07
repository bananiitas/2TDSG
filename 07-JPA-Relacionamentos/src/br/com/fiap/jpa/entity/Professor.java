package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROFESSOR")
@SequenceGenerator(name="prof", sequenceName = "SQ_TB_PROFESSOR",allocationSize = 1)
public class Professor {

	@Id
	@Column(name="nr_pf")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prof")
	private int pf;
	
	@Column(name="nm_professor", nullable = false)
	private String nome;
	
	@Column(name="vl_salario")
	private double salario;
	
	@Column(name="st_ativo")
	private boolean ativo;
	
	//Mapear o relacionamento bidirecional com o projeto (many to many)
	@ManyToMany(mappedBy = "professores")
	private List<Projeto> projetos;
	
	public Professor(String nome, double salario, boolean ativo) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.ativo = ativo;
	}

	public Professor() {
		super();
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
	
}

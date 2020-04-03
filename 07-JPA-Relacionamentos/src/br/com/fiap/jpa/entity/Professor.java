package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	
}

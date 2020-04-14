package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="func",sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario", nullable = false, length = 50)
	private String nome;
	
	@Column(name="vl_salario", nullable = false)
	private double salario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_admissao", nullable = false)
	private Calendar dataAdmissao;
	
	@Column(name="ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}

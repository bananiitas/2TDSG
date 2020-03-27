package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Mapear as classes:

TB_PROFISSAO
	*cd_profissao NUMBER (PK)
	*nm_profissao VARCHAR2(50)
	vl_salario_medio FLOAT
	ds_departamento VARCHAR2(30)
	
TB_EMPRESA
	*cd_empresa NUMBER (PK)
	*nm_empresa VARCHAR2(100)
	dt_abertura DATE
	ds_segmento VARCHAR2 (Enum no Java)
	
Os c�digos ser�o gerados atraves de sequence:
SQ_TB_PROFISSAO
SQ_TB_EMPRESA	

 */
@Entity
@Table(name="TB_PROFISSAO")
@SequenceGenerator(name="prof", sequenceName = "SQ_TB_PROFISSAO", allocationSize = 1)
public class Profissao {

	@Id
	@Column(name="cd_profissao")
	@GeneratedValue(generator = "prof", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_profissao", nullable = false, length = 50)
	private String nome;
	
	@Column(name="vl_salario")
	private float salario;
	
	@Column(name="ds_departamento", length = 30)
	private String departamento;
	
	public Profissao(String nome, float salario, String departamento) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.departamento = departamento;
	}

	public Profissao() {
		super();
	}

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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
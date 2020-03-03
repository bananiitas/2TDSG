package br.com.fiap.jpa.entity;

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
@Table(name="TB_BEBIDA")
@SequenceGenerator(name="bebida",sequenceName ="SQ_TB_BEBIDA",allocationSize = 1 )
public class Bebida {

	@Id
	@Column(name="cd_bebida")
	@GeneratedValue(generator = "bebida",strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_bebida", nullable = false, length = 30)
	private String nome;
	
	@Column(name="nr_alcool")
	private float teorAlcoolico;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_vencimento")
	private Calendar dataVencimento;
	
	@Column(name="vl_bebida")
	private float valor;
	
	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

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

	public float getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(float teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
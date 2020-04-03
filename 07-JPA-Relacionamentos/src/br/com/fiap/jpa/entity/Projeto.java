package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO")
@SequenceGenerator(name="projeto", sequenceName = "SQ_TB_PROJETO", allocationSize = 1)
public class Projeto {

	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto")
	private int codigo;
	
	@Column(name="ds_tema", nullable = false, length = 200)
	private String tema;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrega", nullable = false)
	private Calendar dataEntrega;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	
	
}

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name="end",sequenceName = "SQ_TB_ENDERECO",allocationSize = 1)
public class Endereco {

	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(generator = "end", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_logradouro", nullable = false, length = 90)
	private String logradouro;
	
	@Column(name="nr_cep", length = 9)
	private String cep;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}

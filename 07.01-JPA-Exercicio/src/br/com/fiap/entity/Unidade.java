package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_UNIDADE")
@SequenceGenerator(name="unidade", sequenceName = "SQ_TB_UNIDADE", allocationSize = 1)
public class Unidade {

	@Id
	@Column(name="cd_unidade")
	@GeneratedValue(generator = "unidade", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_unidade", nullable = false, length = 100)
	private String nome;

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
	
}

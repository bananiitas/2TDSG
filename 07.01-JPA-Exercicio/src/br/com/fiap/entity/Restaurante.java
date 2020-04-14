package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_RESTAURANTE")
@SequenceGenerator(name="rest", sequenceName = "SQ_TB_RESTAURANTE", allocationSize = 1)
public class Restaurante {

	@Id
	@Column(name="cd_restaurante")
	@GeneratedValue(generator = "rest", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_restaurante", nullable = false, length = 90)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_culinaria")
	private Culinaria culinaria;

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

	public Culinaria getCulinaria() {
		return culinaria;
	}

	public void setCulinaria(Culinaria culinaria) {
		this.culinaria = culinaria;
	}
	
}

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARGO")
@SequenceGenerator(name="cargo", sequenceName = "SQ_TB_CARGO", allocationSize = 1)
public class Cargo {

	@Id
	@Column(name="cd_cargo")
	@GeneratedValue(generator = "cd_cargo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_cargo", nullable = false, length = 40)
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

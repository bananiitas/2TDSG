package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno",sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="nr_rm")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int rm;
	
	@Column(name="nm_aluno", length = 80, nullable = false)
	private String nome;
	
	@Column(name="ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	//Mapeamento do relacionamento: muitos-para-um
	//Pensar da classe que estamos para a classe da relação (Muitos alunos para um Grupo)
	@ManyToOne
	@JoinColumn(name="cd_grupo")
	private Grupo grupo;
	
	public Aluno(String nome, Genero genero) {
		super();
		this.nome = nome;
		this.genero = genero;
	}

	public Aluno() {
		super();
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}

package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRUPO")
@SequenceGenerator(name="grupo", sequenceName = "SQ_TB_GRUPO",allocationSize = 1)
public class Grupo {

	@Id
	@Column(name="cd_grupo")
	@GeneratedValue(generator = "grupo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_grupo", length = 50, nullable = false)
	private String nome;
	
	//Mapeamento bidirecional um-para-um
	//mappedBy, sempre utilizado no mapeamento bidirecional
	//mappedBy -> atributo que mapeia o relacionamento no banco (Classe Projeto)
	@OneToOne(mappedBy = "grupo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Projeto projeto;
	
	//Mapeamento bidirecional um-para-muitos
	@OneToMany(mappedBy = "grupo")
	private List<Aluno> alunos;
	
	public Grupo(String nome) {
		super();
		this.nome = nome;
	}

	public Grupo() {
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}

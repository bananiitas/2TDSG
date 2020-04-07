package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	
	//Relacionamento muitos-para-muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
	//JoinTable configura a tabela associativa (name -> nome da tabela)
	//joinColumns -> configura a coluna que armazena a FK da classe que estamos
	//inverseJoinColumns -> configura a coluna que armazena a FK do outro lado da relação
	@JoinTable(name="TB_PROJETO_PROFESSOR",
			joinColumns = @JoinColumn(name="cd_projeto"),
			inverseJoinColumns = @JoinColumn(name="nr_pf"))
	private List<Professor> professores;
	
	//Relacionamento um-para-um
	//cascade -> realiza as ações na classe do relacionamento
	//fetch -> configura o momento que será carregada a relação: LAZY e EAGER
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_grupo", nullable = false)
	private Grupo grupo;
	
	public Projeto(String tema, Calendar dataEntrega, Grupo grupo) {
		super();
		this.tema = tema;
		this.dataEntrega = dataEntrega;
		this.grupo = grupo;
	}

	public Projeto() {
		super();
	}

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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	
	
}

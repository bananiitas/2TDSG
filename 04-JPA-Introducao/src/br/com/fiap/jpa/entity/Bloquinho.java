package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BLOQUINHO")
//sequenceName -> nome da sequencia no banco de dados
//name -> nome da sequencia no Java, utilizado no @GeneratedValue
//allocationSize -> incremento
@SequenceGenerator(sequenceName = "SQ_TB_BLOQUINHO", name = "bloq", allocationSize = 1)
public class Bloquinho {

	@Id
	@Column(name="cd_bloquinho")
	@GeneratedValue(generator = "bloq", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="nm_bloquinho", nullable = false, length = 25)
	private String nome;
	
	@Column(name="nm_artista", length = 50)
	private String artista;
	
	@Column(name="dt_bloquinho")
	private Calendar data;
	
	@Column(name="nr_publico")
	private int publico;
	
	@Column(name="vl_ingresso")
	private double valor;
	
}









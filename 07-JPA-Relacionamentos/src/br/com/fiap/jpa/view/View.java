package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Grupo;
import br.com.fiap.jpa.entity.Professor;
import br.com.fiap.jpa.entity.Projeto;

public class View {

	public static void main(String[] args) {
		//Criar a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o grupo
		Grupo grupo = new Grupo("Indios");

		//Instanciar o projeto
		Projeto projeto = new Projeto("Doação de orgãos, uma forma de amor", 
				new GregorianCalendar(2020, Calendar.OCTOBER, 20), grupo);
		
		//Adicionando alunos no grupo
		grupo.addAlunos(new Aluno("Nathan", Genero.MASCULINO));
		grupo.addAlunos(new Aluno("Thiago", Genero.MASCULINO));
		
		//Adicionar os professores no projeto
		//Criar uma lista de professores
		List<Professor> profs = new  ArrayList<Professor>();
		//Adicionar professores na lista
		profs.add(new Professor("Allen", 20000, true));
		profs.add(new Professor("Jesus", 15000, true));
		
		//Setar a lista de professores no projeto
		projeto.setProfessores(profs);

		//Cadastrar o grupo e projeto
		//em.persist(grupo);
		em.persist(projeto);
		
		//Remover
		//Projeto busca = em.find(Projeto.class, 4); //projeto de código 1
		//em.remove(busca);
		
		//Pesquisar um projeto
		//Projeto pesquisa = em.find(Projeto.class, 3);
		//Exibir o tema do projeto
		//System.out.println(pesquisa.getTema());
		//Exibir o nome do grupo
		//System.out.println(pesquisa.getGrupo().getNome());
		
		//Transações, para efetuar as alterações no banco
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}
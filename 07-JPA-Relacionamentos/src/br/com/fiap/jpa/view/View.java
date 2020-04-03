package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Grupo;
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
		
		//Cadastrar o grupo e projeto
		//em.persist(grupo);
		//em.persist(projeto);
		
		//Remover
		//Projeto busca = em.find(Projeto.class, 4); //projeto de código 1
		//em.remove(busca);
		
		//Pesquisar um projeto
		Projeto pesquisa = em.find(Projeto.class, 3);
		//Exibir o tema do projeto
		System.out.println(pesquisa.getTema());
		//Exibir o nome do grupo
		//System.out.println(pesquisa.getGrupo().getNome());
		
		//Transações, para efetuar as alterações no banco
		//em.getTransaction().begin();
		//em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}
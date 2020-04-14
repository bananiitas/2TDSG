package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ProjetoDAO;
import br.com.fiap.jpa.dao.impl.ProjetoDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Grupo;
import br.com.fiap.jpa.entity.Professor;
import br.com.fiap.jpa.entity.Projeto;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View2 {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		//Instanciar a fabrica e o Entity Manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o ProjetoDAO
		ProjetoDAO dao = new ProjetoDAOImpl(em);
		
		//Instanciar o Grupo
		Grupo grupo = new Grupo("Vingadores");
		
		//Instanciar o Projeto com o grupo
		Projeto projeto = new Projeto("Salvar o mundo", Calendar.getInstance(), grupo);
		
		//Instanciar os alunos e adicionar no grupo
		grupo.addAlunos(new Aluno("Viuva", Genero.FEMININO));
		grupo.addAlunos(new Aluno("Gavião", Genero.MASCULINO));
		
		//Instanciar os professores e adicionar em uma lista
		List<Professor> lista = new ArrayList<Professor>();
		lista.add(new Professor("Homem de ferro", 100000, false));
		lista.add(new Professor("Dr. Estranho", 10000, true));
		
		//Adicionar a lista de professores no projeto
		projeto.setProfessores(lista);
		
		try {
			//Cadastra o projeto
			dao.cadastrar(projeto);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar..");
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
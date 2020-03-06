package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.dao.impl.BebidaDAOImpl;
import br.com.fiap.jpa.entity.Bebida;
import br.com.fiap.jpa.entity.Tipo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NoDataException;

public class Teste {

	public static void main(String[] args) {
		//Instanciar a fabrica
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		//Instanciar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar uma BebidaDAOIml...
		BebidaDAO dao = new BebidaDAOImpl(em);
		
		//Instanciar a bebida que será cadastrada
		Bebida refri = new Bebida("Dolly Cola 350ml", 0, 
				new GregorianCalendar(2020, Calendar.AUGUST, 10),
				3, Tipo.REFRIGERANTE);
		
		try {
			//Cadastrar uma bebida
			dao.cadastrar(refri);
			dao.commit();
			System.out.println("Cadastrado com sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar");
		}
		
		//Buscar uma bebida
		Bebida busca = dao.pesquisar(refri.getCodigo());
		System.out.println(busca.getNome());
		
		try {
			//Atualizar uma bebida
			busca.setNome("Pepsi");		
			dao.atualizar(busca);
			dao.commit();
			System.out.println("Bebida atualizada!");
		} catch (CommitException e) {
			System.out.println("Erro ao atualizar");
		}
		
		//Remover uma bebida
		try {
			dao.apagar(busca.getCodigo());
			dao.commit();
			System.out.println("Bebida removida!");
		} catch (NoDataException e) {
			System.out.println("Bebida não encontrada");
		} catch (CommitException e) {
			System.out.println("Erro ao remover");
		}

		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}


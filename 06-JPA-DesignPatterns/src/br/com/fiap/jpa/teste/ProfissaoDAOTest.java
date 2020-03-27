package br.com.fiap.jpa.teste;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.ProfissaoDAO;
import br.com.fiap.jpa.dao.impl.ProfissaoDAOImpl;
import br.com.fiap.jpa.entity.Profissao;
import br.com.fiap.jpa.exception.CommitException;

class ProfissaoDAOTest {

	static ProfissaoDAO dao;
	
	//Método que é executado antes de todos os testes
	@BeforeAll
	static void inicializar() {
		//Instanciar os objetos (DAO, EntityManager, EntityManagerFactory)
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		dao = new ProfissaoDAOImpl(em);
	}
	
	
	
	@Test
	void pesquisaSucessoTest() {
		
	}
	
	@Test
	void cadastroSucessoTest() {
		//Arrange
		Profissao prof = new Profissao("Gerente", 1000, "Vendas");
		
		//Act
		//Chamar o método de cadastro
		dao.cadastrar(prof);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste");
		}
		
		//Assert
		//Validar se realmente cadastrou no banco
		assertNotEquals(0, prof.getCodigo()); //valida se foi gerado um código para PK
	}

}
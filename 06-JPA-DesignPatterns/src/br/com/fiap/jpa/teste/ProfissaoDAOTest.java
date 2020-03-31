package br.com.fiap.jpa.teste;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.ProfissaoDAO;
import br.com.fiap.jpa.dao.impl.ProfissaoDAOImpl;
import br.com.fiap.jpa.entity.Profissao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NoDataException;

class ProfissaoDAOTest {

	static ProfissaoDAO dao;
	Profissao prof;
	
	//Método que é executado antes de todos os testes
	@BeforeAll
	static void inicializar() {
		//Instanciar os objetos (DAO, EntityManager, EntityManagerFactory)
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		dao = new ProfissaoDAOImpl(em);
	}
	
	//Método que é executado antes de cada teste
	@BeforeEach
	void cadastrar() {
		//Arrange
		prof = new Profissao("Gerente", 1000, "Vendas");
		
		//Act
		//Chamar o método de cadastro
		dao.cadastrar(prof);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste");
		}
	}
	
	//Teste de atualização e remoção com sucesso
	@Test
	@DisplayName("Remoção de uma profisão com sucesso")
	void remocaoSucessoTest() {
		//Remover a profissao
		try {
			dao.deletar(prof.getCodigo());
			dao.commit();
		} catch (NoDataException | CommitException e) {
			fail("Falha no teste");
		}
		
		//Validar se a profissao foi removida
		//Valida se a exceção ocorreu na chamada do método
		assertThrows(NoDataException.class, () -> { dao.pesquisar(prof.getCodigo()); });
		
	}
	
	@Test
	@DisplayName("Atualização de uma profissão com sucesso")
	void atualizacaoSucessoTest() {
		//Atualizar a profissão
		prof.setDepartamento("TI");
		prof.setNome("Dev");
		prof.setSalario(9999);
		
		dao.atualizar(prof);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste");
		}
		
		validarValoresProfissao();
		
	}

	private void validarValoresProfissao() {
		//Validar se a atualização foi realizada
		try {
			Profissao busca = dao.pesquisar(prof.getCodigo());
			assertEquals(prof.getCodigo(), busca.getCodigo());
			assertEquals(prof.getDepartamento(), busca.getDepartamento());
			assertEquals(prof.getNome(), busca.getNome());
			assertEquals(prof.getSalario(), busca.getSalario());
		} catch (NoDataException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	@DisplayName("Pesquisa de uma profissão com sucesso")
	void pesquisaSucessoTest() {
		validarValoresProfissao();
	}
	
	@Test
	@DisplayName("Cadastro de uma profissão com sucesso")
	void cadastroSucessoTest() {
		//Assert
		//Validar se realmente cadastrou no banco
		assertNotEquals(0, prof.getCodigo()); //valida se foi gerado um código para PK
	}

}
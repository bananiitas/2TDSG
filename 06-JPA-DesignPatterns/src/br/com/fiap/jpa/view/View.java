package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ProfissaoDAO;
import br.com.fiap.jpa.dao.impl.ProfissaoDAOImpl;
import br.com.fiap.jpa.entity.Profissao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NoDataException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma instância da fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DAO
		ProfissaoDAO dao = new ProfissaoDAOImpl(em);
		
		try {
			//Cadastrar uma profissao
			Profissao prof = new Profissao("Dentista", 10000, "Consultório");
			dao.cadastrar(prof);
			System.out.println("Cadastrado!");
			
			//Buscar uma profissão
			Profissao busca = dao.pesquisar(prof.getCodigo());
			System.out.println(busca.getNome());
			
			//Atualizar
			prof.setSalario(3000);
			dao.atualizar(prof);
			System.out.println("Atualizado!");
	
			//Remover
			dao.deletar(prof.getCodigo());
			System.out.println("Removido!");
			
			dao.commit();
			
		} catch (NoDataException | CommitException e) {
			e.printStackTrace();
		}
		
		//fechar
		em.close();
		fabrica.close();
	}
	
}

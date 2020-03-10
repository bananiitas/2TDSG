package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a instância de EntityManagerFactory
 * permitindo uma única instância na aplicação
 */
public class EntityManagerFactorySingleton {

	/**
	 * Atributo estático que armazena a única instância
	 */
	private static EntityManagerFactory fabrica;
	
	/**
	 * Construtor privado: ninguem pode instanciar a classe
	 */
	private EntityManagerFactorySingleton() {}
	
	/**
	 * @return A única instância da fabrica
	 */
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}









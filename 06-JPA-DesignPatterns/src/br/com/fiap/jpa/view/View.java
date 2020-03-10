package br.com.fiap.jpa.view;

import javax.persistence.EntityManagerFactory;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma instância da fabrica
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		
		
		
		//fechar
		fabrica.close();
	}
	
}

package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NoDataException;

/*
 * CRIAR O DAO GENÉRICO (INTERFACE E CLASSE)
 * CRIAR UM DAO PARA CADA ENTIDADE
 * CRIAR O SINGLETON (EntityManagerFactorySingleton)
 */

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em){
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) 
								getClass().getGenericSuperclass())
											.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(T entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pesquisar(K codigo) throws NoDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(K codigo) throws NoDataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		
	}

}

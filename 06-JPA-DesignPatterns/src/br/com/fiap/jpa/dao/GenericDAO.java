package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NoDataException;

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T pesquisar(K chave) throws NoDataException;
	
	void deletar(K chave) throws NoDataException;
	
	void commit() throws CommitException;
	
}
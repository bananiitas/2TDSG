package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.ProfissaoDAO;
import br.com.fiap.jpa.entity.Profissao;

public class ProfissaoDAOImpl 
					extends GenericDAOImpl<Profissao, Integer> implements ProfissaoDAO {

	public ProfissaoDAOImpl(EntityManager em) {
		super(em);
	}
	
}
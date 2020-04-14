package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GrupoDAO;
import br.com.fiap.jpa.entity.Grupo;

public class GrupoDAOImpl extends GenericDAOImpl<Grupo, Integer> implements GrupoDAO{

	public GrupoDAOImpl(EntityManager em) {
		super(em);
	}

}

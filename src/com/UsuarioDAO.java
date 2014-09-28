package com;

import javax.persistence.EntityManager;

import com.toolmanager.dao.GenericDAO;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
	}

}

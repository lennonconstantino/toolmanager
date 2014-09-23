package com;

import javax.persistence.EntityManager;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
	}

}

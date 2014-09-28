package com.toolmanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.toolmanager.dao.GenericDAO;
import com.toolmanager.dao.UserDAO;
import com.toolmanager.model.User;
//import com.toolmanager.model.Task;

public class UserDaoImpl extends GenericDAO<User> implements UserDAO {

	public UserDaoImpl(EntityManager entityManager) {
		super(User.class, entityManager);
	}

	@Override
	public void insert(User user) {
		super.save(user);
	}

	@Override
	public void remove(User user) {
		super.delete(user);
	}

	@Override
	public User getUser(String username) {
		String sql = "SELECT u FROM user u WHERE u.username = :param";
		return super.get(sql, username);
	}

	@Override
	public User getUserById(Long id_user) {
		return super.getById(id_user);
	}

	@Override
	public List<User> findAll() {
		return super.findAll();
	}
/*
	@Override
	public List<User> findUsers(User user) {
		
		if(!user.getLogin().isEmpty()){
			getCriteria().lilike("name", "%" + user.getLogin() + "%").ignoreCase()
				.addOrder(Order.asc("name"));
		}
		
		if(!user.getUsername().isEmpty()){
			criteria.add(Restrictions.like("username", "%" + user.getUsername() + "%").ignoreCase())
				.addOrder(Order.asc("username"));	
		}
		
	
		return criteria.list();
	}
	*/
}

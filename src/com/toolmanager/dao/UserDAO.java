package com.toolmanager.dao;

import java.util.List;

import com.toolmanager.model.User;

public interface UserDAO {
	public void insert(User user);
	public void update(User user);
	public void remove(User user);
	public User getUser(String username);
	public User getUserById(Long id_user);
	public List<User> findUsers(User user);
	public List<User> findAll();
}

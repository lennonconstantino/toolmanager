package com.toolmanager.service;

import java.util.List;

import com.SimpleEntityManager;
import com.toolmanager.dao.UserDAO;
import com.toolmanager.dao.impl.UserDaoImpl;
import com.toolmanager.model.User;

public class UserService {
	private UserDAO dao;
	private SimpleEntityManager simpleEntityManager;
	
    public UserService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new UserDaoImpl(simpleEntityManager.getEntityManager());
    }
    
    public void insert(User user){
        try{
            simpleEntityManager.beginTransaction();
            //user.validate();
            dao.insert(user);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }

    public void update(User user){
        try{
            simpleEntityManager.beginTransaction();
            dao.update(user);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
    
    public User getUserById(Long id_user)
    {
    	return dao.getUserById(id_user);
    }
    
    public List<User> findAll(){
        return dao.findAll();
    }    
}

package com.toolmanager.service;

import java.util.List;

import com.SimpleEntityManager;
import com.toolmanager.dao.TaskDAO;
import com.toolmanager.dao.impl.TaskDaoImpl;
import com.toolmanager.model.Task;

public class TaskService {
	private TaskDAO dao;
	private SimpleEntityManager simpleEntityManager;
	
    public TaskService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new TaskDaoImpl(simpleEntityManager.getEntityManager());
    }
    
    public void insert(Task task){
        try{
            simpleEntityManager.beginTransaction();
            dao.insert(task);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Task> findAll(Long id_person){
        return dao.findAllofPerson(id_person);
    }
}

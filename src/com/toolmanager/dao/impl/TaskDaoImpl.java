package com.toolmanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.toolmanager.dao.GenericDAO;
import com.toolmanager.dao.TaskDAO;
import com.toolmanager.model.Task;

public class TaskDaoImpl extends GenericDAO<Task> implements TaskDAO {

	public TaskDaoImpl(EntityManager entityManager) {
		super(Task.class, entityManager);
	}

	@Override
	public void insert(Task task) {
		super.save(task);
	}
	
	@Override
	public void update(Task task)
	{
		super.update(task);
	}

	@Override
	public void delete(Task task)
	{
		super.delete(task);
	}
	
	@Override
	public Task getTaskById(Long id_task) {
		return super.getById(id_task);
	}

	@Override
	public Task getTaskByName(String name) {
		String sql = "SELECT t FROM task t WHERE t.name = :param";
		return super.get(sql, name);
	}

	@Override
	public List<Task> findAllofPerson(Long id_person) {
		String sql = "SELECT t.id_task, t.name, t.description, t.date_started, " +
					 "t.date_finished, t.progress, t.rememberMe, t.status, t.role " +
					 "FROM task t, person_task p " +
					 "WHERE t.id_task = p.tasks_id_task " +
					 "AND p.person_id_person = " + id_person;
		return super.getList(sql);
	}
}

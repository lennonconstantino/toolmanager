package com.toolmanager.dao;

import java.util.List;

import com.toolmanager.model.Task;

public interface TaskDAO {
	public void update(Task task);
	public void insert(Task task);
	public void delete(Task task);
	public Task getTaskById(Long id_task);
	public Task getTaskByName(String name);
	public List<Task> findAllofPerson(Long id_person);
}

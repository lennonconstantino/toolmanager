package com.toolmanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.toolmanager.dao.GenericDAO;
import com.toolmanager.dao.NoteDAO;
import com.toolmanager.model.Note;

public class NoteDaoImpl extends GenericDAO<Note> implements NoteDAO {

	public NoteDaoImpl(EntityManager entityManager) {
		super(Note.class, entityManager);
	}

	@Override
	public void insert(Note note) {
		super.save(note);
	}
	
	@Override
	public void update(Note note)
	{
		super.update(note);
	}
	
	@Override
	public void delete(Note note)
	{
		super.delete(note);
	}
	
	@Override
	public Note getNoteById(Long id_note) {
		return super.getById(id_note);
	}

	@Override
	public Note getNoteByName(String name) {
		String sql = "SELECT n FROM note n WHERE n.name = :param";
		return super.get(sql, name);
	}

	@Override
	public List<Note> findAllNote(Long id_person) {
		String sql = "SELECT n.id_note, n.name, n.description, n.dateCreation, n.dateLastAlter, n.role " +
					 "FROM note n, person_note p " +
					 "WHERE n.id_note = p.notes_id_note " +
					 "AND p.person_id_person = " + id_person;
		return super.getList(sql);
	}
}

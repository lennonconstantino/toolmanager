package com.toolmanager.service;

import java.util.List;

import com.SimpleEntityManager;
import com.toolmanager.dao.NoteDAO;
import com.toolmanager.dao.impl.NoteDaoImpl;
import com.toolmanager.model.Note;

public class NoteService {
	private NoteDAO dao;
	private SimpleEntityManager simpleEntityManager;
	
    public NoteService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new NoteDaoImpl(simpleEntityManager.getEntityManager());
    }
    
    public void insert(Note note){
        try{
            simpleEntityManager.beginTransaction();
            dao.insert(note);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
    
    public Note getNoteById(Long id_note)
    {
    	return dao.getNoteById(id_note);
    }
    
    public Note getNoteByName(String name)
    {
    	return dao.getNoteByName(name);
    }
    
    public List<Note> findAll(Long id_person){
        return dao.findAllNote(id_person);
    }	
}

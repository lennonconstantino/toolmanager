package com.toolmanager.dao;

import java.util.List;

import com.toolmanager.model.Note;

public interface NoteDAO {
	public static final String FIND_NOTE_BY_NAME = "Note.findNoteByName";
	public static final String FIND_NOTES_BY_ID_PERSON_OWNER = "Note.findNotesByIdPersonOwner";
	
	public void update(Note note);
	public void insert(Note note);
	public void delete(Note note);
	public Note getNoteById(Long id_note);
	public Note getNoteByName(String name);
	public List<Note> findAllNote(Long id_person);
}

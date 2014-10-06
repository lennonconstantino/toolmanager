package com.toolmanager.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue
	@Column(name="id_book")	
	private Long id_book;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name="dateCreation")	
	private Calendar dateCreation;
	//@ManyToMany(cascade = CascadeType.PERSIST)
    //Set<Note> notes;
	
	@OneToMany(cascade = CascadeType.ALL) //fetch = FetchType.LAZY,
	@JoinColumn(unique=false, nullable=true, insertable=true, updatable=true)
	//@JoinTable(name="book_note",
	//joinColumns=@JoinColumn(name="id_book_fk"),
	//inverseJoinColumns=@JoinColumn(name="id_note_fk"))
    List<Note> notes;	
	
	public Book(){}
	/**
	 * @param name
	 * @param description
	 * @param dateCreation
	 * @param notes
	 */
	public Book(String name, String description, Calendar dateCreation,
			List<Note> notes) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
		this.notes = notes;
	}
	public Long getId_book() {
		return id_book;
	}
	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Calendar getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Calendar dateCreation) {
		this.dateCreation = dateCreation;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}

package com;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@ManyToMany(cascade = CascadeType.PERSIST)
    Set<Note> notes;	
	
	public Book(){}
	/*
	public Book(String name, String description, Calendar dateCreation) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
	}
	*/
	public Book(String name, String description, Calendar dateCreation,
			Set<Note> notes) {
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
	public Set<Note> getNotes() {
		return notes;
	}
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
}

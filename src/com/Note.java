package com;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="note")
public class Note {
	@Id
	@GeneratedValue
	@Column(name="id_note")		
	private Long id_note;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name="dateCreation")	
	private Calendar dateCreation;
	
	public Note(){}
	public Note(String name, String description, Calendar dateCreation) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
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
	
}

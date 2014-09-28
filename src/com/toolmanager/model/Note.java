package com.toolmanager.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
	@Temporal(TemporalType.DATE)
	@Column(name="dateLastAlter")
	private Calendar dateLastAlter;	
	@Enumerated
	private Role role;
	
	public Note(){}
	/**
	 * @param name
	 * @param description
	 * @param dateCreation
	 * @param dateLastAlter
	 * @param role
	 */
	public Note(String name, String description, Calendar dateCreation,
			Calendar dateLastAlter, Role role) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateLastAlter = dateLastAlter;
		this.role = role;
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
	public Long getId_note() {
		return id_note;
	}
	public void setId_note(Long id_note) {
		this.id_note = id_note;
	}
	public Calendar getDateLastAlter() {
		return dateLastAlter;
	}
	public void setDateLastAlter(Calendar dateLastAlter) {
		this.dateLastAlter = dateLastAlter;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Note [id_note=" + id_note + ", name=" + name + ", description="
				+ description + ", dateCreation=" + dateCreation
				+ ", dateLastAlter=" + dateLastAlter + ", role=" + role + "]";
	}
}

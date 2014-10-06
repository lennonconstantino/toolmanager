package com.toolmanager.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;

@Entity
@Table(name="note")
@NamedQueries({
	@NamedQuery(name="Note.findNoteByName",query="SELECT n FROM Note n WHERE n.name = :param"),
	@NamedQuery(name="Note.findNotesByIdPersonOwner",query="SELECT n FROM Note n WHERE n.id_person_owner = :param")
})
public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
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
	@Column(name="id_person_owner")
	private Long id_person_owner;
	
	public Note(){}
	/**
	 * @param name
	 * @param description
	 * @param dateCreation
	 * @param dateLastAlter
	 * @param id_person_owner
	 * @param role
	 */
	public Note(String name, String description, Calendar dateCreation,
			Calendar dateLastAlter, Long id_person_owner, Role role) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateLastAlter = dateLastAlter;
		this.id_person_owner = id_person_owner;
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
	Long getId_person_owner()
	{
		return id_person_owner;
	}
	void setId_person_owner(Long id_person_owner)
	{
		this.id_person_owner = id_person_owner; 
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
				+ ", dateLastAlter=" + dateLastAlter + ", id_person_owner = " + id_person_owner 
				+ ", role=" + role + "]";
	}
}

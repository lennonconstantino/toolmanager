package com.toolmanager.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;


@Entity
@Table(name="task")

public class Task {
	@Id
	@GeneratedValue
	@Column(name="id_task")		
	private Long id_task;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="date_started")
	@Temporal(TemporalType.DATE)
	private Calendar date_started;
	@Column(name="date_finished")
	@Temporal(TemporalType.DATE)
	private Calendar date_finished;
	@Column(name="progress")
	private int progress;
	@Column(name="rememberMe")
	private boolean rememberMe;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Enumerated
	private Role role;
	@Column(name="id_person_owner")
	Long id_person_owner;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(unique=false, nullable=true, insertable=true, updatable=true)
	//@JoinTable(name="task_book",
	//joinColumns=@JoinColumn(name="id_task",unique=false, nullable=true, insertable=true, updatable=true),
	//inverseJoinColumns=@JoinColumn(name="id_book"))
    List<Book> books;	
	
	public Task(){}
	/**
	 * @param name
	 * @param description
	 * @param date_started
	 * @param date_finished
	 * @param progress
	 * @param rememberMe
	 * @param status
	 * @param role
	 * @param id_person_owner
	 * @param books
	 */
	public Task(String name, String description, Calendar date_started,
			Calendar date_finished, int progress, boolean rememberMe,
			Status status, Role role, Long id_person_owner, List<Book> books) {
		super();
		this.name = name;
		this.description = description;
		this.date_started = date_started;
		this.date_finished = date_finished;
		this.progress = progress;
		this.rememberMe = rememberMe;
		this.status = status;
		this.role = role;
		this.id_person_owner = id_person_owner;
		this.books = books;
	}
	public Long getId_task() {
		return id_task;
	}
	public void setId_task(Long id_task) {
		this.id_task = id_task;
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
	public Calendar getDate_started() {
		return date_started;
	}
	public void setDate_started(Calendar date_started) {
		this.date_started = date_started;
	}
	public Calendar getDate_finished() {
		return date_finished;
	}
	public void setDate_finished(Calendar date_finished) {
		this.date_finished = date_finished;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	Long getId_person_owner()
	{
		return id_person_owner;
	}
	void setId_person_owner(Long id_person_owner)
	{
		this.id_person_owner = id_person_owner;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}	
	@Override
	public String toString() {
		return "Task [id_task=" + id_task + ", name=" + name + ", description="
				+ description + ", date_started=" + date_started
				+ ", date_finished=" + date_finished + ", progress=" + progress
				+ ", id_person_owner=" + id_person_owner
				+ ", rememberMe=" + rememberMe + "]";
	}
}

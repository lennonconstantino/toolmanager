package com.toolmanager.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue
	@Column(name="id_person")	
	private Long id_person;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Temporal(TemporalType.DATE)
	@Column(name="birthday")	
	private Calendar birthday;
	@OneToOne
	@JoinColumn(name="id_address")	
	private Address address;
	@ManyToMany(cascade = CascadeType.ALL)
	Set<Task> tasks;
	
	@ManyToMany(cascade = CascadeType.ALL)
    Set<Book> books;
	
	@ManyToMany(cascade = CascadeType.ALL)
	Set<Note> notes;
	
	public Person(){}
	/**
	 * @param firstname
	 * @param lastname
	 * @param birthday
	 * @param address
	 * @param tasks
	 * @param books
	 * @param notes
	 */
	public Person(String firstname, String lastname, Calendar birthday,
			Address address, Set<Task> tasks, Set<Book> books, Set<Note> notes) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.address = address;
		this.tasks = tasks;
		this.books = books;
		this.notes = notes;
	}
	public Long getId_person() {
		return id_person;
	}
	public void setId_person(Long id_person) {
		this.id_person = id_person;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	public Set<Note> getNotes() {
		return notes;
	}
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}	
	@Override
	public String toString() {
		return "Person [id_person=" + id_person + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", birthday=" + birthday
				+ ", address=" + address + ", tasks=" + tasks + ", books="
				+ books + ", notes=" + notes + "]";
	}
}

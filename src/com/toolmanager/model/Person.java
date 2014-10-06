package com.toolmanager.model;

import java.util.Calendar;
import java.util.List;

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
//import javax.persistence.JoinColumns;
//import javax.persistence.JoinTable;



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
	@ManyToMany(/*mappedBy="person",*/ cascade = CascadeType.ALL)
	//@JoinTable(name="person_task", joinColumns={@JoinColumn(name="id_person")}, inverseJoinColumns={@JoinColumn(name="id_task")})
	List<Task> tasks;
	
	@ManyToMany(/*mappedBy="person",*/ cascade = CascadeType.ALL)
	
    List<Book> books;
	
	@ManyToMany(/*mappedBy="person",*/ cascade = CascadeType.ALL)
	List<Note> notes;
	
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
			Address address, List<Task> tasks, List<Book> books, List<Note> notes) {
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
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

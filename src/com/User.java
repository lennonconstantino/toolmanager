package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="id_person")
public class User extends Person {
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	@Temporal(TemporalType.DATE)
	@Column(name="lastLogin")	
	private Calendar lastLogin;
	
	public User(){}
	public User(String login, String password, String username,
			Calendar lastLogin) {
		super();
		this.login = login;
		this.password = password;
		this.username = username;
		this.lastLogin = lastLogin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Calendar getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Calendar lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String toString = String.format("User[username: %s " +
										"login: %s password: %s " +
										"lastLogin: %s " +
										"firstname: %s lastname: %s " +
										"birthday: %s ]",
										this.getUsername(),
										this.getLogin(),
										this.getPassword(),
										sdf.format(this.getLastLogin().getTime()),
										this.getFirstname(),
										this.getLastname(),
										sdf.format(this.getBirthday().getTime()));
		return toString;
	}
}

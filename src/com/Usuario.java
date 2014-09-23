package com;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Lob;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(unique = true, name = "email")
	private String email ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataDeCadastro")
	private Calendar dataDeCadastro ;
	
	@Lob
	@Column(name="foto")
	private byte [] foto ;
	
	public Usuario(){}
	/**
	 * @param id
	 * @param email
	 * @param dataDeCadastro
	 * @param foto
	 */
	public Usuario(String email, Calendar dataDeCadastro, byte[] foto) {
		super();
		this.email = email;
		this.dataDeCadastro = dataDeCadastro;
		this.foto = foto;
	}	
	
	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
    public void validate(){
        if(email == null){
            throw new IllegalArgumentException("email cannot be null");
        }
    }	
}

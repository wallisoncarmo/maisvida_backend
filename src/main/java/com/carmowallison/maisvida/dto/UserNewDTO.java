package com.carmowallison.maisvida.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.carmowallison.maisvida.domain.User;

public class UserNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
	private String first_name;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
	private String last_name;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Email(message = "E-mail inválido!")
	private String email;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho precisa ser de 5 a 120 caracter!")
	private String senha;
	
	private boolean active;
	private boolean status;
	
	public UserNewDTO() {
	}
	
	
	public UserNewDTO(User obj) {		

		first_name = obj.getFirstName();
		last_name = obj.getLastName();
		email = obj.getEmail();
		active = obj.isActive();
		status = obj.isStatus();
		senha = obj.getSenha();
	}



	public String getFirst_name() {
		return first_name;
	}


	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}


	public String getLastName() {
		return last_name;
	}


	public void setLastName(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

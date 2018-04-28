package com.carmowallison.maisvida.dto;

import java.io.Serializable;

import com.carmowallison.maisvida.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private boolean active;
	private boolean status;
	
	public UserDTO() {
	}
	
	
	public UserDTO(User obj) {		
		id = obj.getId();
		first_name = obj.getFirstName();
		last_name = obj.getLastName();
		email = obj.getEmail();
		active = obj.isActive();
		status = obj.isStatus();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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
	
	
	
	
}
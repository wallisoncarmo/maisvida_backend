package com.carmowallison.maisvida.dto;

import java.io.Serializable;

import com.carmowallison.maisvida.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private boolean active;
	
	public UserDTO() {
	}
	
	
	public UserDTO(User obj) {		
		id = obj.getId();
		email = obj.getEmail();
		name = obj.getName();
		active = obj.isActive();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}

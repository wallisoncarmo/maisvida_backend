package com.carmowallison.maisvida.dto;

import java.io.Serializable;

import com.carmowallison.maisvida.domain.Especialidade;

public class EspecialidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private boolean active;
	
	public EspecialidadeDTO() {
	}
	
	public EspecialidadeDTO(Especialidade obj) {		
		id = obj.getId();
		name = obj.getName();
		active = obj.isActive();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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

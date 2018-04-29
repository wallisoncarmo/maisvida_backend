package com.carmowallison.maisvida.dto;

import java.io.Serializable;

import com.carmowallison.maisvida.domain.Cidade;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private EstadoDTO estado;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {		
		id = obj.getId();
		name = obj.getName();
		estado = obj.getEstado();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}	
	
}

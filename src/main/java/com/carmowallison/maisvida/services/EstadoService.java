package com.carmowallison.maisvida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmowallison.maisvida.domain.Estado;
import com.carmowallison.maisvida.dto.EstadoDTO;
import com.carmowallison.maisvida.repositoties.EstadoRepository;
import com.carmowallison.maisvida.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> findAll() {
		return repository.findAll();
	}

	public Estado findById(String id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Estado insert(Estado obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Estado update(Estado obj) {
		Estado newObj = findById(obj.getId());
		updateData(newObj, obj);

		return repository.save(newObj);
	}

	private void updateData(Estado newObj, Estado obj) {

		if (obj.getName() != null) {
			newObj.setName(obj.getName());
		}

	}

	public Estado fromDTO(EstadoDTO objDTO) {
		return new Estado(objDTO.getId(), objDTO.getName());
	}

}

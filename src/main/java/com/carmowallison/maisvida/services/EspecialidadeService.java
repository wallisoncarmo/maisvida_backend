package com.carmowallison.maisvida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmowallison.maisvida.domain.Especialidade;
import com.carmowallison.maisvida.dto.EspecialidadeDTO;
import com.carmowallison.maisvida.repository.EspecialidadeRepository;
import com.carmowallison.maisvida.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository repository;

	public List<Especialidade> findAll() {
		return repository.findAll();
	}

	public Especialidade findById(String id) {
		Optional<Especialidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Especialidade insert(Especialidade obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Especialidade update(Especialidade obj) {
		Especialidade newObj = findById(obj.getId());
		updateData(newObj, obj);

		return repository.save(newObj);
	}

	private void updateData(Especialidade newObj, Especialidade obj) {
		if (obj.getName() != null) {
			newObj.setName(obj.getName());
		}

	}

	public Especialidade fromDTO(EspecialidadeDTO objDTO) {
		return new Especialidade(objDTO.getId(), objDTO.getName());
	}

}

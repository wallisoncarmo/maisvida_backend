package com.carmowallison.maisvida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmowallison.maisvida.domain.Cidade;
import com.carmowallison.maisvida.dto.CidadeDTO;
import com.carmowallison.maisvida.repository.CidadeRepository;
import com.carmowallison.maisvida.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public List<Cidade> findAll() {
		return repository.findAll();
	}

	public Cidade findById(String id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Cidade insert(Cidade obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Cidade update(Cidade obj) {
		Cidade newObj = findById(obj.getId());
		updateData(newObj, obj);

		return repository.save(newObj);
	}

	private void updateData(Cidade newObj, Cidade obj) {

		newObj.setActive(obj.isActive());
		if (obj.getName() != null) {
			newObj.setName(obj.getName());
		}

	}

	public Cidade fromDTO(CidadeDTO objDTO) {
		return new Cidade(objDTO.getId(), objDTO.getName(), objDTO.isActive());
	}

}

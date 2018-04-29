package com.carmowallison.maisvida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carmowallison.maisvida.domain.Medico;
import com.carmowallison.maisvida.dto.MedicoDTO;
import com.carmowallison.maisvida.dto.MedicoNewDTO;
import com.carmowallison.maisvida.repository.MedicoRepository;
import com.carmowallison.maisvida.services.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Medico findById(String id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Medico insert(Medico obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Medico update(Medico obj) {
		Medico newObj = findById(obj.getId());
		updateData(newObj, obj);

		return repository.save(newObj);
	}

	private void updateData(Medico newObj, Medico obj) {

		newObj.setActive(obj.isActive());
		newObj.setStatus(obj.isStatus());

		if (obj.getEmail() != null) {
			newObj.setEmail(obj.getEmail());
		}

		if (obj.getFirstName() != null) {
			newObj.setFirstName(obj.getFirstName());
		}

		if (obj.getLastName() != null) {
			newObj.setLastName(obj.getLastName());
		}

		if (obj.getEspecialidade() != null) {
			newObj.setEspecialidade(obj.getEspecialidade());
		}

		if (obj.getCidade() != null) {
			newObj.setCidade(obj.getCidade());
		}

	}

	public Medico fromDTO(MedicoDTO objDTO) {
		return new Medico(objDTO.getId(), objDTO.getFirst_name(), objDTO.getLastName(), objDTO.getEmail(),
				objDTO.isActive(), objDTO.isStatus(), objDTO.getEspecialidade(), objDTO.getCidade());
	}

	public Medico fromDTO(MedicoNewDTO objDTO) {

		return new Medico(null, objDTO.getFirst_name(), objDTO.getLastName(), objDTO.getEmail(), objDTO.isActive(),
				objDTO.isStatus(), objDTO.getEspecialidade(), objDTO.getCidade());
	}
	
	
	public Page<Medico> findPage(Integer page,Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}

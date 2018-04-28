package com.carmowallison.maisvida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmowallison.maisvida.domain.User;
import com.carmowallison.maisvida.dto.UserDTO;
import com.carmowallison.maisvida.dto.UserNewDTO;
import com.carmowallison.maisvida.repository.UserRepository;
import com.carmowallison.maisvida.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);

		return repository.save(newObj);
	}

	private void updateData(User newObj, User obj) {

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
		if (obj.getSenha() != null) {
			newObj.setSenha(obj.getSenha());
		}		
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getFirst_name(), objDTO.getLastName(), objDTO.getEmail(),
				objDTO.isActive(), objDTO.isStatus(), null);
	}

	public User fromDTO(UserNewDTO objDTO) {
		return new User(null, objDTO.getFirst_name(), objDTO.getLastName(), objDTO.getEmail(), objDTO.isActive(),
				objDTO.isStatus(), objDTO.getSenha());
	}
}

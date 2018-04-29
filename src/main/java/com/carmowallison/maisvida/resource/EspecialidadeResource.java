package com.carmowallison.maisvida.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carmowallison.maisvida.domain.Especialidade;
import com.carmowallison.maisvida.dto.EspecialidadeDTO;
import com.carmowallison.maisvida.services.EspecialidadeService;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeResource {

	@Autowired
	private EspecialidadeService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EspecialidadeDTO>> findAll() {
		List<Especialidade> list = service.findAll();
		List<EspecialidadeDTO> listDTO = list.stream().map(obj -> new EspecialidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EspecialidadeDTO> findById(@PathVariable String id) {
		Especialidade obj = service.findById(id);
		return ResponseEntity.ok().body(new EspecialidadeDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EspecialidadeDTO objDTO) {
		Especialidade obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody EspecialidadeDTO objDTO) {
		Especialidade obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

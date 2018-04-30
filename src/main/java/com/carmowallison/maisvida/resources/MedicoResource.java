package com.carmowallison.maisvida.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carmowallison.maisvida.domain.Medico;
import com.carmowallison.maisvida.dto.MedicoDTO;
import com.carmowallison.maisvida.dto.MedicoNewDTO;
import com.carmowallison.maisvida.services.MedicoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService service;

	@ApiOperation(value = "Busca Todos os Médicos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MedicoDTO>> findAll() {
		List<Medico> list = service.findAll();
		List<MedicoDTO> listDTO = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@ApiOperation(value = "Busca por um Médico pelo seu id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MedicoDTO> findById(@PathVariable String id) {
		Medico obj = service.findById(id);
		return ResponseEntity.ok().body(new MedicoDTO(obj));
	}

	@ApiOperation(value = "insere um novo Médico")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MedicoNewDTO objDTO) {
		Medico obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Atualiza um Médico")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody MedicoNewDTO objDTO) {
		
		Medico obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Deleta um Médico")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Busca Todos os Médicos e separa por paginação")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Medico> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MedicoDTO> listDTO = list.map(obj -> new MedicoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}

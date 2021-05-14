package com.mattos.gestaofinanceira.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mattos.gestaofinanceira.domain.Receita;
import com.mattos.gestaofinanceira.dto.ReceitaNewDTO;
import com.mattos.gestaofinanceira.dto.ReceitaUpdateDTO;
import com.mattos.gestaofinanceira.services.ReceitaService;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService service;

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ReceitaNewDTO dto) {
		Receita receita = service.fromDTO(dto);
		receita = service.insert(receita);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(receita.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Receita> find(@PathVariable Integer id) {

		Receita receita = service.find(id);

		return ResponseEntity.ok().body(receita);
	}

	@GetMapping(value = "/pages")
	public ResponseEntity<Page<Receita>> findPage(@PageableDefault(size = 10, sort = {"mesReferencia", "id"}, direction = Direction.DESC ) Pageable pageable) {
		
		Page<Receita> page = service.findPage(pageable);
		return ResponseEntity.ok(page);
	}

	@GetMapping
	public ResponseEntity<List<Receita>> findAll() {
		List<Receita> receitas = service.findAll();

		return ResponseEntity.ok().body(receitas);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ReceitaUpdateDTO dto) {
		Receita receita = service.fromDTO(dto);
		receita.setId(id);
		receita = service.update(receita);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}
}

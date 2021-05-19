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

import com.mattos.gestaofinanceira.domain.Despesa;
import com.mattos.gestaofinanceira.dto.DespesaNewDTO;
import com.mattos.gestaofinanceira.dto.DespesaPageDTO;
import com.mattos.gestaofinanceira.dto.DespesaUpdateDTO;
import com.mattos.gestaofinanceira.services.DespesaService;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaController {

	@Autowired
	private DespesaService service;

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody DespesaNewDTO dto) {
		Despesa despesa = service.fromDTO(dto);
		despesa = service.insert(despesa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesa.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Despesa> find(@PathVariable Integer id) {

		Despesa despesa = service.find(id);

		return ResponseEntity.ok().body(despesa);
	}

	@PostMapping(value = "/pages")
	public ResponseEntity<Page<Despesa>> findPage(
			@PageableDefault(size = 5, sort = { "dataVencimento", "id" }, direction = Direction.DESC) Pageable pageable,
			@RequestBody DespesaPageDTO dto) {
		Page<Despesa> page = service.findAllPaginated(dto, pageable);

		return ResponseEntity.ok(page);
	}

	@GetMapping
	public ResponseEntity<List<Despesa>> findAll() {
		List<Despesa> despesas = service.findAll();

		return ResponseEntity.ok().body(despesas);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody DespesaUpdateDTO dto) {
		Despesa despesa = service.fromDTO(dto);
		despesa.setId(id);
		despesa = service.update(despesa);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}
}

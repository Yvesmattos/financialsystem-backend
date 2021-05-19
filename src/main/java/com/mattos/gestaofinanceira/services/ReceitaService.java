package com.mattos.gestaofinanceira.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mattos.gestaofinanceira.domain.Receita;
import com.mattos.gestaofinanceira.domain.UserAccount;
import com.mattos.gestaofinanceira.dto.ReceitaNewDTO;
import com.mattos.gestaofinanceira.dto.ReceitaPageDTO;
import com.mattos.gestaofinanceira.dto.ReceitaUpdateDTO;
import com.mattos.gestaofinanceira.repositories.ReceitaRepository;
import com.mattos.gestaofinanceira.repositories.UserAccountRepository;
import com.mattos.gestaofinanceira.services.exceptions.ObjectNotFoundException;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository repository;

	@Autowired
	private UserAccountRepository userRep;

	public Receita find(Integer id) {
		Optional<Receita> receita = repository.findById(id);

		return receita.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " , Tipo: " + Receita.class.getName()));
	}

	@Transactional(readOnly = true)
	public List<Receita> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Receita> findAllPaginated(ReceitaPageDTO dto, Pageable pageable) {

		int auxSit = dto.getSituacao() != null ? dto.getSituacao().getCod() : 0;
		String auxDate = dto.getMesReferencia() != null ? dto.getMesReferencia().toString() : "";

		if (dto.getOrigem() == null) {
			dto.setOrigem("");
		}
		if (dto.getNomeReceita() == null) {
			dto.setNomeReceita("");
		}
		if (dto.getFormaPagamento() == null) {
			dto.setFormaPagamento("");
		}
		if (dto.getMeioPagamento() == null) {
			dto.setMeioPagamento("");
		}

		return repository.findAllPaginated(dto.getNomeReceita(), dto.getOrigem(), dto.getFormaPagamento(),
				dto.getMeioPagamento(), pageable);
	}

	@Transactional
	public Receita insert(Receita receita) {
		receita.setId(null);
		receita.getUser().getReceitas().add(receita);
		receita.setDataAlteracao(new Date());
		receita = repository.save(receita);

		return receita;
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}

	public Receita update(Receita receita) {
		Receita novaReceita = find(receita.getId());
		updateData(receita, novaReceita);
		receita.setDataAlteracao(new Date());
		return repository.save(novaReceita);
	}

	public Receita fromDTO(ReceitaUpdateDTO dto) {
		Receita receita = new Receita(dto.getId(), dto.getNomeReceita(), dto.getDataCredito(), dto.getOrigem(),
				dto.getMesReferencia(), dto.getValorReceita(), dto.getMeioPagamento(), dto.getFormaPagamento(),
				dto.getValorPago(), null, (dto.getSituacao()));

		return receita;
	}

	public Receita fromDTO(ReceitaNewDTO dto) {
		UserAccount user;

		if (userRep.findAll().isEmpty()) {
			user = userRep.save(new UserAccount(null, "Yves Mattos", "yvesmattos@gmail.com"));
			System.out.println(userRep.findAll());
		} else {
			user = userRep.getOne(1);
		}

		Receita receita = new Receita(null, dto.getNomeReceita(), dto.getDataCredito(), dto.getOrigem(),
				dto.getMesReferencia(), dto.getValorReceita(), dto.getMeioPagamento(), dto.getFormaPagamento(),
				dto.getValorPago(), user, dto.getSituacao());

		return receita;
	}

	private void updateData(Receita receita, Receita novaReceita) {
		novaReceita.setNomeReceita(receita.getNomeReceita());
		novaReceita.setOrigem(receita.getOrigem());
		novaReceita.setFormaPagamento(receita.getFormaPagamento());
		novaReceita.setMeioPagamento(receita.getMeioPagamento());
		novaReceita.setValorReceita(receita.getValorReceita());
		novaReceita.setValorPago(receita.getValorPago());
		novaReceita.setMesReferencia(receita.getMesReferencia());
		novaReceita.setDataCredito(receita.getDataCredito());
		if (receita.getSituacao() != null) {
			novaReceita.setSituacao(receita.getSituacao());
		}
	}
}

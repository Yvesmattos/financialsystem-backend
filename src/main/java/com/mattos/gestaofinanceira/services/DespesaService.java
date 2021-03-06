package com.mattos.gestaofinanceira.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mattos.gestaofinanceira.domain.Despesa;
import com.mattos.gestaofinanceira.domain.UserAccount;
import com.mattos.gestaofinanceira.dto.DespesaNewDTO;
import com.mattos.gestaofinanceira.dto.DespesaPageDTO;
import com.mattos.gestaofinanceira.dto.DespesaUpdateDTO;
import com.mattos.gestaofinanceira.repositories.DespesaRepository;
import com.mattos.gestaofinanceira.repositories.UserAccountRepository;
import com.mattos.gestaofinanceira.services.exceptions.ObjectNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;

	@Autowired
	private UserAccountRepository userRep;

	public Despesa find(Integer id) {
		Optional<Despesa> despesa = repository.findById(id);

		return despesa.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " , Tipo: " + Despesa.class.getName()));
	}

	@Transactional(readOnly = true)
	public List<Despesa> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Despesa> findAllPaginated(DespesaPageDTO dto, Pageable pageable) {

		int auxSit = dto.getSituacao() != null ? dto.getSituacao().getCod() : 0;
		String auxDate = dto.getMesReferencia() != null ? dto.getMesReferencia().toString() : "";

		if (dto.getFavorecido() == null) {
			dto.setFavorecido("");
		}
		if (dto.getNomeDespesa() == null) {
			dto.setNomeDespesa("");
		}
		if (dto.getFormaPagamento() == null) {
			dto.setFormaPagamento("");
		}
		if (dto.getMeioPagamento() == null) {
			dto.setMeioPagamento("");
		}

		System.out.println(dto.getFavorecido());

		return repository.findAllPaginated(dto.getNomeDespesa(), dto.getFavorecido(), dto.getFormaPagamento(),
				dto.getMeioPagamento(), pageable);
	}

	@Transactional
	public Despesa insert(Despesa despesa) {
		despesa.setId(null);
		despesa.getUser().getDespesas().add(despesa);
		despesa.setDataAlteracao(new Date());
		despesa = repository.save(despesa);

		return despesa;
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}

	public Despesa update(Despesa despesa) {
		Despesa novaDespesa = find(despesa.getId());
		updateData(despesa, novaDespesa);
		despesa.setDataAlteracao(new Date());
		return repository.save(novaDespesa);
	}

	public Despesa fromDTO(DespesaUpdateDTO dto) {
		Despesa despesa = new Despesa(dto.getId(), dto.getNomeDespesa(), dto.getFavorecido(), dto.getFormaPagamento(),
				dto.getMeioPagamento(), dto.getMesReferencia(), dto.getDataVencimento(), dto.getDataPagamento(),
				dto.getValorDespesa(), dto.getValorPago(), null, dto.getSituacao());

		return despesa;
	}

	public Despesa fromDTO(DespesaNewDTO dto) {
		UserAccount user;

		if (userRep.findAll().isEmpty()) {
			user = userRep.save(new UserAccount(null, "Yves Mattos", "yvesmattos@gmail.com"));
		} else {
			user = userRep.getOne(1);
		}

		Despesa despesa = new Despesa(null, dto.getNomeDespesa(), dto.getFavorecido(), dto.getFormaPagamento(),
				dto.getMeioPagamento(), dto.getMesReferencia(), dto.getDataVencimento(), dto.getDataPagamento(),
				dto.getValorDespesa(), dto.getValorPago(), user, dto.getSituacao());

		return despesa;
	}

	private void updateData(Despesa despesa, Despesa novaDespesa) {
		novaDespesa.setNomeDespesa(despesa.getNomeDespesa());
		novaDespesa.setFavorecido(despesa.getFavorecido());
		novaDespesa.setFormaPagamento(despesa.getFormaPagamento());
		novaDespesa.setMeioPagamento(despesa.getMeioPagamento());
		novaDespesa.setValorDespesa(despesa.getValorDespesa());
		novaDespesa.setValorPago(despesa.getValorPago());
		novaDespesa.setMesReferencia(despesa.getMesReferencia());
		novaDespesa.setDataVencimento(despesa.getDataVencimento());
		novaDespesa.setDataPagamento(despesa.getDataPagamento());
		if (despesa.getSituacao() != null) {
			novaDespesa.setSituacao(despesa.getSituacao());
		}
	}
}

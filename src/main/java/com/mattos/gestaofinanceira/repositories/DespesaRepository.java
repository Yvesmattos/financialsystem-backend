package com.mattos.gestaofinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattos.gestaofinanceira.domain.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}

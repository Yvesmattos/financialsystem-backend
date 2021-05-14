package com.mattos.gestaofinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattos.gestaofinanceira.domain.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

}

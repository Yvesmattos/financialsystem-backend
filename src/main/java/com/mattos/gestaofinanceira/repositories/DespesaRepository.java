package com.mattos.gestaofinanceira.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mattos.gestaofinanceira.domain.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

	@Query("SELECT obj from Despesa obj where obj.nomeDespesa LIKE %:nomeDespesa AND obj.favorecido LIKE %:favorecido% AND obj.formaPagamento LIKE %:formaPagamento% AND obj.meioPagamento LIKE %:meioPagamento%")
	Page<Despesa> findAllPaginated(@Param("nomeDespesa") String nomeDespesa, @Param("favorecido") String favorecido,
			@Param("formaPagamento") String formaPagamento, @Param("meioPagamento") String meioPagamento,
			Pageable pageable);
}

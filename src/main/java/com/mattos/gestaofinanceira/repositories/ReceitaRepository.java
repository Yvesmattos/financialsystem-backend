package com.mattos.gestaofinanceira.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mattos.gestaofinanceira.domain.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
	
	@Query("SELECT obj from Receita obj where obj.nomeReceita LIKE %:nomeReceita AND obj.origem LIKE %:origem% AND obj.formaPagamento LIKE %:formaPagamento% AND obj.meioPagamento LIKE %:meioPagamento%")
	Page<Receita> findAllPaginated(@Param("nomeReceita") String nomeReceita, @Param("origem") String origem,
			@Param("formaPagamento") String formaPagamento, @Param("meioPagamento") String meioPagamento,
			Pageable pageable);

}

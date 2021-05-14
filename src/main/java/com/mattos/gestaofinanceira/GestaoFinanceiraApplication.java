package com.mattos.gestaofinanceira;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mattos.gestaofinanceira.domain.Despesa;
import com.mattos.gestaofinanceira.domain.Receita;
import com.mattos.gestaofinanceira.domain.UserAccount;
import com.mattos.gestaofinanceira.domain.enums.Situacao;
import com.mattos.gestaofinanceira.repositories.DespesaRepository;
import com.mattos.gestaofinanceira.repositories.ReceitaRepository;
import com.mattos.gestaofinanceira.repositories.UserAccountRepository;

@SpringBootApplication
public class GestaoFinanceiraApplication implements CommandLineRunner {
	
	@Autowired
	private UserAccountRepository userRep;
	
	@Autowired
	private DespesaRepository desp;
	
	@Autowired
	private ReceitaRepository rec;

	SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
	
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		SpringApplication.run(GestaoFinanceiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UserAccount user = new UserAccount(null, "Yves Mattos", "yvesmattos@gmail.com");
		userRep.save(user);
		
		Despesa despesa = new Despesa(null, "Cartão de crédito", "C6", "À vista", "Transferência", sdf.parse("04/2021"), sdf2.parse("10/05/2021"), null, 252.52, 0.0, user, Situacao.PENDENTE);
		Despesa despesa2 = new Despesa(null, "Cartão de crédito", "Nubank", "À vista", "Transferência", sdf.parse("04/2021"), sdf2.parse("12/05/2021"), null, 1300.52, 0.0, user, Situacao.PENDENTE);
		
		desp.saveAll(Arrays.asList(despesa, despesa2));
		
		Receita receita = new Receita(null, "Salário", null, "PHC Foco", sdf.parse("03/2021"), 1100.0, "Dinheiro", "À vista", 0.0, user, Situacao.PENDENTE);
		Receita receita2 = new Receita(null, "Bônus produtividade", null, "PHC Foco", sdf.parse("04/2021"), 125.0, "Dinheiro", "À vista", 0.0, user, Situacao.PENDENTE);
		
		rec.saveAll(Arrays.asList(receita, receita2));
	}

}

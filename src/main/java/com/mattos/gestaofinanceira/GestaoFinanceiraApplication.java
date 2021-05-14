package com.mattos.gestaofinanceira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mattos.gestaofinanceira.domain.UserAccount;
import com.mattos.gestaofinanceira.repositories.UserAccountRepository;

@SpringBootApplication
public class GestaoFinanceiraApplication implements CommandLineRunner{
	
	@Autowired
	private UserAccountRepository user;
	
	public static void main(String[] args) {
		SpringApplication.run(GestaoFinanceiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		user.save(new UserAccount(null, "Yves Mattos", "yvesmattos@gmail.com"));
		
	}

}

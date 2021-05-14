package com.mattos.gestaofinanceira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattos.gestaofinanceira.domain.UserAccount;
import com.mattos.gestaofinanceira.repositories.UserAccountRepository;
import com.mattos.gestaofinanceira.services.exceptions.ObjectNotFoundException;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository repository;

	public UserAccount find(Integer id) {
		Optional<UserAccount> user = repository.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " , Tipo: " + UserAccount.class.getName()));
	}

	public List<UserAccount> findAll() {
		return repository.findAll();
	}

	public UserAccount insert(UserAccount user) {
		user.setId(null);
		user = repository.save(user);

		return user;
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}

	public UserAccount update(UserAccount user) {
		UserAccount newUserAccount = find(user.getId());
		updateData(user, newUserAccount);
		return repository.save(newUserAccount);
	}

	private void updateData(UserAccount oldUser, UserAccount newUserAccount) {
		newUserAccount.setEmail(oldUser.getEmail());
		newUserAccount.setNome(oldUser.getNome());
	}
}

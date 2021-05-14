package com.mattos.gestaofinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattos.gestaofinanceira.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

}

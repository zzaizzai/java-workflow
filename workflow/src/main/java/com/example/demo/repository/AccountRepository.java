package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>  {

	Account findByLoginId(String loginId);

	
	@Query("select a from Account a")
	List<Account> findByidQuery();
	
	@Query("select a from Account a where a.id = ?1")
	Account findByidQueryOne(Integer id);
	
	@Query("select a from Account a where a.isAdmin = false ")
	List<Account> findByidQueryNotAdmin();
}

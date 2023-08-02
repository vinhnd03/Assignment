package edu.poly.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.asm.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
}

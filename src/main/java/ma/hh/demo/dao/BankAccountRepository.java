package ma.hh.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hh.demo.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
	

}

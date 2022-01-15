package ma.hh.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.hh.demo.dao.BankAccountRepository;
import ma.hh.demo.dao.ServicexRepository;
import ma.hh.demo.model.BankAccount;
import ma.hh.demo.model.Servicex;

@Service @Transactional
public class BankAccountService implements IBankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	@Autowired
	ServicexRepository servicexRepository;

	@Override
	public BankAccount addBankAccount(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}

	@Override
	public BankAccount describeBankAccount(Long id) {
		return bankAccountRepository.findById(id).get();
	}

	@Override
	public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
		bankAccount.setId(id);
		return bankAccountRepository.save(bankAccount);
	}

	@Override
	public void removeBankAccount(Long id) {
		bankAccountRepository.deleteById(id);
	}

	@Override
	public List<BankAccount> getAllBankAccounts() {
		return bankAccountRepository.findAll();
	}
	@Override
	public String payService(Long userId, Long serviceId) {
		Servicex service = servicexRepository.getById(serviceId);
		BankAccount account = bankAccountRepository.getById(userId);
		long currentbalance = account.getBalance()-service.getPrice();
		account.setBalance(currentbalance);
		updateBankAccount(userId, account);
		return "the service" + service.getTitle() + "was paid, the current account balance is :" + currentbalance;
		
	}
}

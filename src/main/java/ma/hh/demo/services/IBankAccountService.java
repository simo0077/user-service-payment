package ma.hh.demo.services;

import java.util.List;

import ma.hh.demo.model.BankAccount;


public interface IBankAccountService {

	public BankAccount addBankAccount(BankAccount bankAccount);

	public BankAccount describeBankAccount(Long id);

	public BankAccount updateBankAccount(Long id, BankAccount bankAccount);

	public void removeBankAccount(Long id);

	public List<BankAccount> getAllBankAccounts();

	public String payService(Long userId, Long serviceId);


}

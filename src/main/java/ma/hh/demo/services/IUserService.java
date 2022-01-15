package ma.hh.demo.services;

import java.util.List;

import ma.hh.demo.model.BankAccount;
import ma.hh.demo.model.User;

public interface IUserService {

	public User addUser(User user);

	public User describeUser(Long id);

	public User updateUser(Long id, User user);

	public void removeUser(Long id);

	public List<User> getAllUser();

	public List<BankAccount> getBankAccount();
	
}

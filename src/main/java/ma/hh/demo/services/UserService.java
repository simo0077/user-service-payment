package ma.hh.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.hh.demo.dao.UserRepository;
import ma.hh.demo.model.BankAccount;
import ma.hh.demo.model.User;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User describeUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public List<BankAccount> getBankAccount(){
		return null;
		
	}
}

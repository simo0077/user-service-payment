
package ma.hh.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.hh.demo.model.BankAccount;
import ma.hh.demo.model.User;
import ma.hh.demo.services.IBankAccountService;
import ma.hh.demo.services.IUserService;

@RestController
@RequestMapping("/api-demo/users")
public class UserController {

	@Autowired
	IUserService userService;
	@Autowired
	IBankAccountService bankAccountService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	User create(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/{id}")
	User findById(@PathVariable Long id) {
		return userService.describeUser(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	User update(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	void delete(@PathVariable Long id) {
		userService.removeUser(id);
		bankAccountService.removeBankAccount(id);
	}

	@GetMapping
	List<User> findAll() {
		return userService.getAllUser();
	}
	
	
	//bankaccounts
	
	@GetMapping("/{id}/bankaccount")
	BankAccount findUserBankAccount(@PathVariable Long id) {
		return bankAccountService.describeBankAccount(id);
	}
	@PutMapping("/{userId}/bankaccount")
	@ResponseStatus(HttpStatus.OK)
	BankAccount update(@PathVariable Long id, @RequestBody BankAccount account) {
		return bankAccountService.updateBankAccount(id, account);
	}
	
	@PutMapping("/{userId}/service/{serviceId}")
	@ResponseStatus(HttpStatus.OK)
	String update(@PathVariable Long userId, @PathVariable Long serviceId) {
		return bankAccountService.payService(userId, serviceId);
	}
}

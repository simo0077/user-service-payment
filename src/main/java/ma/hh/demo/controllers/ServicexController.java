
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

import ma.hh.demo.model.Servicex;

import ma.hh.demo.services.IServicexService;
import ma.hh.demo.services.ServicexService;

@RestController
@RequestMapping("/api-demo/services")
public class ServicexController {
	
	@Autowired
	IServicexService servicexService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Servicex create(@RequestBody Servicex service) {
		return servicexService.addServicex(service);
	}
	
	@GetMapping("/{id}")
	Servicex findById(@PathVariable Long id) {
		return servicexService.describeServicex(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	Servicex update(@PathVariable Long id, @RequestBody Servicex service) {
		return servicexService.updateServicex(id, service);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	void delete(@PathVariable Long id) {
		servicexService.removeServicex(id);
	}
	
	@GetMapping
	List<Servicex> findAll() {
		return servicexService.getAllServicexs();
	}
}

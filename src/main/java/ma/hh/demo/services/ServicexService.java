package ma.hh.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ma.hh.demo.dao.ServicexRepository;
import ma.hh.demo.model.Servicex;

@Service @Transactional
public class ServicexService implements IServicexService {

	@Autowired
	ServicexRepository servicexRepository;

	@Override
	public Servicex addServicex(Servicex service) {
		return servicexRepository.save(service);
	}

	@Override
	public Servicex describeServicex(Long id) {
		return servicexRepository.findById(id).get();
	}

	@Override
	public Servicex updateServicex(Long id, Servicex service) {
		service.setId(id);
		return servicexRepository.save(service);
	}

	@Override
	public void removeServicex(Long id) {
		servicexRepository.deleteById(id);
	}

	@Override
	public List<Servicex> getAllServicexs() {
		return servicexRepository.findAll();
	}
}

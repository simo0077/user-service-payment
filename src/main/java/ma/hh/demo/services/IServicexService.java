package ma.hh.demo.services;

import java.util.List;


import ma.hh.demo.model.Servicex;

public interface IServicexService {

	public Servicex addServicex(Servicex service);

	public Servicex describeServicex(Long id);

	public Servicex updateServicex(Long id, Servicex service);

	public void removeServicex(Long id);

	public List<Servicex> getAllServicexs();
}

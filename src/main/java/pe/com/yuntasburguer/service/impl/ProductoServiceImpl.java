package pe.com.yuntasburguer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.yuntasburguer.entity.Producto;
import pe.com.yuntasburguer.repository.ProductoRepository;
import pe.com.yuntasburguer.service.ProductoService;

@Service
public class ProductoServiceImpl  implements ProductoService{
	
	@Autowired
	private ProductoRepository repo;

	@Override
	public List<Producto> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Producto> findAllCustom() {
		return repo.findAllCustom();
	}

	@Override
	public Producto findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Producto add(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public Producto update(Producto obj, Long id) {
		Producto productoDB = repo.findById(id).orElse(null);
        if (productoDB == null) return null;

        productoDB.setNombre(obj.getNombre());
        productoDB.setPrecio(obj.getPrecio());

        return repo.save(productoDB);
	}

	@Override
	public Producto delete(Long id) {
		Producto productoDB = repo.findById(id).orElse(null);
	        if (productoDB == null) return null;

	        productoDB.setEstado(false); // Deshabilitado
	        return repo.save(productoDB);
	}

	@Override
	public Producto enable(Long id) {
		Producto productoDB = repo.findById(id).orElse(null);
        if (productoDB == null) return null;

        productoDB.setEstado(true); // Habilitado
        return repo.save(productoDB);
	}
	
	

}

package pe.com.yuntasburguer.service;

import java.util.List;


import pe.com.yuntasburguer.entity.Producto;

public interface ProductoService {
	List<Producto> findAll();
    List<Producto> findAllCustom();
    Producto findById(Long id);
    Producto add(Producto obj);
    Producto update(Producto obj, Long id);
    Producto delete(Long id);
    Producto enable(Long id);
}

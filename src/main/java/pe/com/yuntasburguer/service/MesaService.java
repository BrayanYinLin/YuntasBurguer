package pe.com.yuntasburguer.service;

import java.util.List;

import pe.com.yuntasburguer.entity.Mesa;

public interface MesaService {
	List<Mesa> findAll();
    List<Mesa> findLibres();
    Mesa findById(Integer id);
    Mesa add(Mesa obj);
    Mesa update(Mesa obj, Integer id);
    Mesa delete(Integer id);
    Mesa enable(Integer id);
    Mesa ocuparMesa(Integer id);
}

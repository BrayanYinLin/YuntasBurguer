package pe.com.yuntasburguer.service;

import pe.com.yuntasburguer.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    List<Cliente> findAllEnabled();
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    Cliente update(Integer id, Cliente cliente);
    Cliente delete(Integer id);
    Cliente enable(Integer id);
}

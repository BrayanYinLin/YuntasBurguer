package pe.com.yuntasburguer.service;

import java.util.List;

import pe.com.yuntasburguer.entity.Empleado;

public interface EmpleadoService {
	List<Empleado> findAll();
    List<Empleado> findAllCustom();
    Empleado findById(Long id);
    Empleado add(Empleado obj);
    Empleado update(Empleado obj, Long id);
    Empleado delete(Long id);
    Empleado enable(Long id);
}

package pe.com.yuntasburguer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yuntasburguer.entity.Empleado;
import pe.com.yuntasburguer.repository.EmpleadoRepository;
import pe.com.yuntasburguer.service.EmpleadoService;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repo;

    @Override
    public List<Empleado> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Empleado> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public Empleado findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Empleado add(Empleado obj) {
        obj.setEstado(true); // Siempre entra activo
        return repo.save(obj);
    }

    @Override
    public Empleado update(Empleado obj, Long id) {
        Empleado empleadoDB = repo.findById(id).orElse(null);
        if (empleadoDB == null) return null;

        empleadoDB.setNombre(obj.getNombre());
        empleadoDB.setCargo(obj.getCargo());
        // No tocamos estado acá

        return repo.save(empleadoDB);
    }

    @Override
    public Empleado delete(Long id) {
        Empleado empleadoDB = repo.findById(id).orElse(null);
        if (empleadoDB == null) return null;

        empleadoDB.setEstado(false); // Deshabilitado
        return repo.save(empleadoDB);
    }

    @Override
    public Empleado enable(Long id) {
        Empleado empleadoDB = repo.findById(id).orElse(null);
        if (empleadoDB == null) return null;

        empleadoDB.setEstado(true); // Habilitado
        return repo.save(empleadoDB);
    }

}

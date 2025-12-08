package pe.com.yuntasburguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.yuntasburguer.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {


    @Query("SELECT e FROM Empleado e WHERE e.estado = true")
    List<Empleado> findAllCustom();
}

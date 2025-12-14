package pe.com.yuntasburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.yuntasburguer.entity.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("select e from Cliente e where e.estado = true")
    List<Cliente> findAllActive();
}

package pe.com.yuntasburguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.yuntasburguer.entity.Mesa;

@Repository
public interface MesaRepository  extends JpaRepository<Mesa, Integer>{


	@Query("SELECT m FROM Mesa m WHERE m.estado = pe.com.yuntasburguer.entity.Mesa$EstadoMesa.Libre")
    List<Mesa> findLibres();
}

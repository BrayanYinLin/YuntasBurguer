package pe.com.yuntasburguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.yuntasburguer.entity.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
	  @Query("select dp from DetallePedido dp where dp.estado = true")
	    List<DetallePedido> findAllActive();
}

package pe.com.yuntasburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.yuntasburguer.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

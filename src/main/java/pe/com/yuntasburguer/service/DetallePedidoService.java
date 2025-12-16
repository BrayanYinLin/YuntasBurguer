package pe.com.yuntasburguer.service;

import java.util.List;

import pe.com.yuntasburguer.entity.DetallePedido;

public interface DetallePedidoService {
	  List<DetallePedido> findAll();
	  List<DetallePedido> findAllEnabled();
	  DetallePedido findById(Integer id);
	  DetallePedido save(DetallePedido cliente);
	  DetallePedido update(Integer id, DetallePedido cliente);
	  DetallePedido delete(Integer id);
	  DetallePedido enable(Integer id);
}

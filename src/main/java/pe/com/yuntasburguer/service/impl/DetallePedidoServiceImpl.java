package pe.com.yuntasburguer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.yuntasburguer.entity.Cliente;
import pe.com.yuntasburguer.entity.DetallePedido;
import pe.com.yuntasburguer.repository.DetallePedidoRepository;
import pe.com.yuntasburguer.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
	
	
	@Autowired
	private  DetallePedidoRepository repo;

	@Override
	public List<DetallePedido> findAll() {
		return repo.findAll();
	}

	@Override
	public List<DetallePedido> findAllEnabled() {		
		return repo.findAllActive();
	}

	@Override
	public DetallePedido findById(Integer id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public DetallePedido save(DetallePedido detallepedido) {
		
		return repo.save(detallepedido);
	}

	@Override
	public DetallePedido update(Integer id, DetallePedido detallepedido) {
		DetallePedido dp = repo.findById(id).orElse(null);

        if (dp == null) return null;

        dp.setCantidad(detallepedido.getCantidad());
        dp.setEstado(detallepedido.getEstado());
        dp.setProducto(detallepedido.getProducto());
        dp.setPedido(detallepedido.getPedido());

        return repo.save(dp);
    }

	@Override
	public DetallePedido delete(Integer id) {
		DetallePedido detped = repo.findById(id).orElse(null);

	        if (detped == null) return null;

	        detped.setEstado(false);

	        return repo.save(detped);
	}

	@Override
	public DetallePedido enable(Integer id) {
		DetallePedido detped = repo.findById(id).orElse(null);

        if (detped == null) return null;

        detped.setEstado(false);

        return repo.save(detped);
	}
	
	

	
	

}

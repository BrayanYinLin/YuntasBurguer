package pe.com.yuntasburguer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yuntasburguer.entity.Pedido;
import pe.com.yuntasburguer.repository.PedidoRepository;
import pe.com.yuntasburguer.service.PedidoService;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}

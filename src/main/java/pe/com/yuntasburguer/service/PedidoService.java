package pe.com.yuntasburguer.service;

import pe.com.yuntasburguer.entity.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> getAllPedidos();
    public Pedido savePedido(Pedido pedido);
    public Pedido getPedidoById(Long id);
    public void deletePedido(Long id);
}

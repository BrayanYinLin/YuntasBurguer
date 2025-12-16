package pe.com.yuntasburguer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.yuntasburguer.service.ClienteService;
import pe.com.yuntasburguer.service.EmpleadoService;
import pe.com.yuntasburguer.service.MesaService;
import pe.com.yuntasburguer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;
    private final MesaService mesaService;

    public PedidoController(PedidoService pedidoService, ClienteService clienteService, EmpleadoService empleadoService, MesaService mesaService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.empleadoService = empleadoService;
        this.mesaService = mesaService;
    }

    @GetMapping
    public String listPedidos(Model model) {
        model.addAttribute("listapedidos", pedidoService.getAllPedidos());
        return "Pedidos/listar_pedidos";
    }

    @GetMapping("/registrar")
    public String showRegisterForm(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("mesas", mesaService.findAll());
        model.addAttribute("pedido", new pe.com.yuntasburguer.entity.Pedido());
        return "Pedidos/registrar_pedidos";
    }

    @PostMapping("/registrar")
    public String createPedido(@ModelAttribute("pedido") pe.com.yuntasburguer.entity.Pedido pedido) {
        pedido.setFecha(java.time.LocalDateTime.now());
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/actualizar/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", pedidoService.getPedidoById(id));
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("mesas", mesaService.findAll());
        return "Pedidos/actualizar_pedidos";
    }

    @PostMapping("/actualizar/{id}")
    public String updatePedido(@PathVariable Long id, @ModelAttribute("pedido") pe.com.yuntasburguer.entity.Pedido pedido) {
        pe.com.yuntasburguer.entity.Pedido existingPedido = pedidoService.getPedidoById(id);
        existingPedido.setCliente(pedido.getCliente());
        existingPedido.setEmpleado(pedido.getEmpleado());
        existingPedido.setMesa(pedido.getMesa());
        existingPedido.setEstado(pedido.getEstado());
        pedidoService.savePedido(existingPedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/habilitar")
    public String showEnableDisablePage(Model model) {
        model.addAttribute("listapedidos", pedidoService.getAllPedidos());
        return "Pedidos/habilitar_pedidos";
    }

    @GetMapping("/habilitar/{id}")
    public String enablePedido(@PathVariable Long id) {
        pe.com.yuntasburguer.entity.Pedido pedido = pedidoService.getPedidoById(id);
        pedido.setEstado(true);
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos/habilitar";
    }

    @GetMapping("/deshabilitar/{id}")
    public String disablePedido(@PathVariable Long id) {
        pe.com.yuntasburguer.entity.Pedido pedido = pedidoService.getPedidoById(id);
        pedido.setEstado(false);
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos";
    }
}

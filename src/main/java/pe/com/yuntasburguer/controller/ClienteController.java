package pe.com.yuntasburguer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.yuntasburguer.entity.Cliente;
import pe.com.yuntasburguer.service.ClienteService;

@Controller
@RequestMapping("/menu")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente")
    public String listar(Model model) {
        model.addAttribute("listacliente", this.clienteService.findAll());
        return "Cliente/listar_cliente";
    }

    @GetMapping("/cliente/registrar")
    public String registrar() {
        return "Cliente/registrar_cliente";
    }

    @GetMapping("/cliente/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, Model model) {
        Cliente cliente = this.clienteService.findById(id);

        model.addAttribute("cliente", cliente);

        return "Cliente/actualizar_cliente";
    }

    @GetMapping("/cliente/habilitar/{id}")
    public String habilitarCliente(@PathVariable("id") Integer id) {
        this.clienteService.enable(id);

        return "redirect:/menu/cliente";
    }

    @GetMapping("/cliente/habilitar")
    public String habilitarCliente(Model model) {
        model.addAttribute("listacliente", this.clienteService.findAll());
        return "Cliente/habilitar_cliente";
    }

    @GetMapping("/cliente/deshabilitar/{id}")
    public String deshabilitar(@PathVariable("id") Integer id) {
        this.clienteService.delete(id);

        return "redirect:/menu/cliente";
    }

    @ModelAttribute("cliente")
    public Cliente ModeloEmpleado() {
        return new Cliente();
    }

    @PostMapping("/cliente/crear")
    public String crear(@ModelAttribute("cliente") Cliente cliente) {
        this.clienteService.save(cliente);

        return "redirect:/menu/cliente";
    }

    @PostMapping("/cliente/modificar/{id}")
    public String modificar(@PathVariable("id") Integer id, @ModelAttribute("cliente") Cliente cliente) {
        this.clienteService.update(id, cliente);

        return "redirect:/menu/cliente";
    }
}

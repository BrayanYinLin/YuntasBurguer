package pe.com.yuntasburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.yuntasburguer.entity.Mesa;
import pe.com.yuntasburguer.service.MesaService;

@Controller
public class MesaController {

    @Autowired
    private MesaService servicio;

    @GetMapping("/menu/mesa")
    public String MostrarMenuMesa(Model modelo) {
        modelo.addAttribute("listamesa", servicio.findAll()); 
        return "mesa/listar_mesa";
    }

    @GetMapping("/mesa/listar")
    public String MostrarListarMesa(Model modelo) {
        modelo.addAttribute("listamesa", servicio.findAll());
        return "mesa/listar_mesa";
    }

    @GetMapping("/mesa/habilitar")
    public String MostrarMesaHabilitados(Model modelo) {
        modelo.addAttribute("listamesa", servicio.findAll());
        return "mesa/habilitar_mesa";
    }

    // --- FORMULARIOS ---

    // Mostrar formulario de registro
    @GetMapping("/mesa/registro")
    public String MostrarRegistrarMesa(Model modelo) {
        return "mesa/registrar_mesa";
    }

    // Mostrar formulario de actualización
    @GetMapping("/mesa/actualizar/{id}")
    public String MostrarActualizarMesa(Model modelo, @PathVariable Integer id) { // OJO: Integer
        modelo.addAttribute("mesa", servicio.findById(id));
        return "mesa/actualizar_mesa";
    }

    // --- ACCIONES (GET) PARA CAMBIAR ESTADO ---

    // Deshabilitar (Eliminación Lógica -> Poner estado INACTIVA)
    @GetMapping("/mesa/deshabilitar/{id}")
    public String deshabilitarMesa(@PathVariable Integer id) { // OJO: Integer
        servicio.delete(id); // Recuerda que tu delete ahora pone estado Inactiva
        return "redirect:/mesa/listar";
    }

    // Habilitar (Poner estado LIBRE)
    @GetMapping("/mesa/habilitar/{id}")
    public String habilitarMesa(@PathVariable Integer id) { // OJO: Integer
        servicio.enable(id);
        return "redirect:/mesa/habilitar";
    }

    // Otra ruta para deshabilitar desde la vista de "habilitar"
    @GetMapping("/mesa/disable/{id}")
    public String disableMesa(@PathVariable Integer id) { // OJO: Integer
        servicio.delete(id);
        return "redirect:/mesa/habilitar";
    }

    // --- MODEL ATTRIBUTE ---
    // Esto es necesario para que Thymeleaf entienda el objeto "mesa" en los formularios
    @ModelAttribute("mesa")
    public Mesa ModeloMesa() {
        return new Mesa();
    }

    // --- ACCIONES (POST) PARA GUARDAR ---

    // Registrar Mesa
    @PostMapping("/mesa/registrar")
    public String RegistrarMesa(@ModelAttribute("mesa") Mesa obj) {
        servicio.add(obj);
        return "redirect:/mesa/listar";
    }

    // Actualizar Mesa
    @PostMapping("/mesa/actualizar/{id}")
    public String ActualizarMesa(@ModelAttribute("mesa") Mesa obj, @PathVariable Integer id) { // OJO: Integer
        servicio.update(obj, id);
        return "redirect:/mesa/listar";
    }
    
    
    @GetMapping("/mesa/ocupar/{id}")
    public String ocuparMesa(@PathVariable Integer id) {
        Mesa mesa = servicio.findById(id);
        if (mesa != null) {
            mesa.setEstado(Mesa.EstadoMesa.Ocupada);
            servicio.update(mesa, id); // Guardamos el cambio
        }
        return "redirect:/mesa/listar";
    }

    // RUTA PARA LIBERAR
    @GetMapping("/mesa/liberar/{id}")
    public String liberarMesa(@PathVariable Integer id) {
        Mesa mesa = servicio.findById(id);
        if (mesa != null) {
            mesa.setEstado(Mesa.EstadoMesa.Libre);
            servicio.update(mesa, id);
        }
        return "redirect:/mesa/listar";
    }
}
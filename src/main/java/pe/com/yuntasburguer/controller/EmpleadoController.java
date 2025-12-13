package pe.com.yuntasburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.yuntasburguer.entity.Empleado;
import pe.com.yuntasburguer.service.EmpleadoService;

import java.util.Map;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService servicio;
    
    @GetMapping("/menu/empleado")
    public String MostrarMenuEmpleado(Model modelo) {
        modelo.addAttribute("listaempleado", servicio.findAllCustom());
        return "empleado/listar_empleado";
    }



    // LISTAR SOLO EMPLEADOS ACTIVOS
    @GetMapping("/empleado/listar")
    public String MostrarListarEmpleado(Model modelo) {
        modelo.addAttribute("listaempleado", servicio.findAllCustom());
        return "empleado/listar_empleado";
    }

    // LISTAR TODOS (HABILITADOS Y DESHABILITADOS)
    @GetMapping("/empleado/habilitar")
    public String MostrarEmpleadoHabilitados(Model modelo) {
        modelo.addAttribute("listaempleado", servicio.findAll());
        return "empleado/habilitar_empleado";
    }

    // MOSTRAR FORMULARIO DE REGISTRO
    @GetMapping("/empleado/registro")
    public String MostrarRegistrarEmpleado(Model modelo) {
        return "empleado/registrar_empleado";
    }

    // MOSTRAR FORMULARIO DE ACTUALIZACIÓN
    @GetMapping("/empleado/actualizar/{id}")
    public String MostrarActualizarEmpleado(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("empleado", servicio.findById(id));
        return "empleado/actualizar_empleado";
    }

    // DESHABILITAR EMPLEADO (ELIMINAR LÓGICAMENTE)
    @GetMapping("/empleado/deshabilitar/{id}")
    public String deshabilitarEmpleado(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/empleado/listar";
    }

    // HABILITAR EMPLEADO
    @GetMapping("/empleado/habilitar/{id}")
    public String habilitarEmpleado(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/empleado/habilitar";
    }
    @GetMapping("/empleado/disable/{id}")
    public String disableEmpleado(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/empleado/habilitar";
    }

    // CREAR OBJETO EMPLEADO PARA FORMULARIOS
    @ModelAttribute("empleado")
    public Empleado ModeloEmpleado() {
        return new Empleado();
    }

    // REGISTRAR EMPLEADO (POST)
    @PostMapping("/empleado/registrar")
    public String RegistrarEmpleado(@ModelAttribute("empleado") Empleado obj) {
        servicio.add(obj);
        return "redirect:/empleado/listar";
    }

    // ACTUALIZAR EMPLEADO (POST)
    @PostMapping("/empleado/actualizar/{id}")
    public String ActualizarEmpleado(@ModelAttribute("empleado") Empleado obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/empleado/listar";
    }


}

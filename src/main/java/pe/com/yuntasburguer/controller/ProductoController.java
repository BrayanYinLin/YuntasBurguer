package pe.com.yuntasburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.yuntasburguer.entity.Producto;
import pe.com.yuntasburguer.service.ProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService servicio;


    // Menú principal (Muestra activos)
    @GetMapping("/menu/productos")
    public String MostrarMenuProducto(Model modelo) {
        modelo.addAttribute("listaproductos", servicio.findAllCustom());
        return "Productos/listar_productos";
    }

    // Listar solo productos activos
    @GetMapping("/productos/listar")
    public String MostrarListarProducto(Model modelo) {
        modelo.addAttribute("listaproductos", servicio.findAllCustom());
        return "Productos/listar_productos";
    }

    // Listar TODOS (Habilitados y Deshabilitados) para mantenimiento
    @GetMapping("/producto/habilitar")
    public String MostrarProductosHabilitados(Model modelo) {
        modelo.addAttribute("listaproductos", servicio.findAll());
        return "Productos/habilitar_productos";
    }

    // --- RUTAS DE FORMULARIOS (Vistas) ---

    // Mostrar formulario de registro
    @GetMapping("/producto/registro")
    public String MostrarRegistrarProducto(Model modelo) {
        return "productos/registrar_productos";
    }

    // Mostrar formulario de actualización
    @GetMapping("/producto/actualizar/{id}")
    public String MostrarActualizarProducto(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("producto", servicio.findById(id));
        return "Productos/actualizar_productos";
    }


    // Deshabilitar producto (Eliminación lógica) -> Redirige a la lista normal
    @GetMapping("/producto/deshabilitar/{id}")
    public String deshabilitarProducto(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/productos/listar";
    }

    // Habilitar producto -> Redirige a la lista de mantenimiento
    @GetMapping("/producto/habilitar/{id}")
    public String habilitarProducto(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/producto/habilitar";
    }
    
    // Deshabilitar desde la vista de mantenimiento -> Redirige a mantenimiento
    @GetMapping("/producto/disable/{id}")
    public String disableProducto(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/producto/habilitar";
    }

    // --- MODELO Y PROCESAMIENTO DE DATOS ---

    // Crear objeto Producto vacío para los formularios
    @ModelAttribute("producto")
    public Producto ModeloProducto() {
        return new Producto();
    }

    // PROCESAR EL REGISTRO (POST)
    @PostMapping("/producto/registrar")
    public String RegistrarProducto(@ModelAttribute("producto") Producto obj) {
        servicio.add(obj);
        return "redirect:/productos/listar";
    }

    // PROCESAR LA ACTUALIZACIÓN (POST)
    @PostMapping("/producto/actualizar/{id}")
    public String ActualizarProducto(@ModelAttribute("producto") Producto obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/productos/listar";
    }
}
package pe.com.yuntasburguer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.yuntasburguer.entity.Empleado;
import pe.com.yuntasburguer.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService servicio;

    @GetMapping
    public List<Empleado> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Empleado> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Empleado findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Empleado add(@RequestBody Empleado obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public Empleado update(@RequestBody Empleado obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public Empleado delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public Empleado enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}

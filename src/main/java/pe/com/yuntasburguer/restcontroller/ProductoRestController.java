package pe.com.yuntasburguer.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.yuntasburguer.entity.Producto;
import pe.com.yuntasburguer.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	
	@Autowired
	private ProductoService servicio;
	
	 @GetMapping
	    public List<Producto> findAll() {
	        return servicio.findAll();
	    }

	    @GetMapping("/custom")
	    public List<Producto> findAllCustom() {
	        return servicio.findAllCustom();
	    }

	    @GetMapping("/{id}")
	    public Producto findById(@PathVariable Long id) {
	        return servicio.findById(id);
	    }

	    @PostMapping
	    public Producto add(@RequestBody Producto obj) {
	        return servicio.add(obj);
	    }

	    @PutMapping("/{id}")
	    public Producto update(@RequestBody Producto obj, @PathVariable Long id) {
	        return servicio.update(obj, id);
	    }

	    @DeleteMapping("/{id}")
	    public Producto delete(@PathVariable Long id) {
	        return servicio.delete(id);
	    }

	    @PutMapping("/enable/{id}")
	    public Producto enable(@PathVariable Long id) {
	        return servicio.enable(id);
	    }

}

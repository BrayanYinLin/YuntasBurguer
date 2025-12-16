package pe.com.yuntasburguer.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.yuntasburguer.entity.Cliente;
import pe.com.yuntasburguer.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    private final ClienteService clienteService;
    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/custom")
    public ResponseEntity<List<Cliente>> custom() {
        return ResponseEntity.ok(clienteService.findAllEnabled());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return ResponseEntity.status(201).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.delete(id));
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<Cliente> enable(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.enable(id));
    }
}

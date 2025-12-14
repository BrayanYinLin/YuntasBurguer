package pe.com.yuntasburguer.service.impl;

import org.springframework.stereotype.Service;
import pe.com.yuntasburguer.entity.Cliente;
import pe.com.yuntasburguer.repository.ClienteRepository;
import pe.com.yuntasburguer.service.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;

    public ClienteServiceImpl(ClienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Cliente> findAllEnabled() {
        return repo.findAllActive();
    }

    @Override
    public Cliente findById(Integer id) {
        Optional<Cliente> client = repo.findById(id);

        return client.orElse(null);

    }

    @Override
    public Cliente save(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        Cliente c = repo.findById(id).orElse(null);

        if (c == null) return null;

        c.setNombre(cliente.getNombre());
        c.setEstado(cliente.getEstado());
        c.setTelefono(cliente.getTelefono());

        return repo.save(c);
    }

    @Override
    public Cliente delete(Integer id) {
        Cliente client = repo.findById(id).orElse(null);

        if (client == null) return null;

        client.setEstado(false);

        return repo.save(client);
    }

    @Override
    public Cliente enable(Integer id) {
        Cliente client = repo.findById(id).orElse(null);

        if (client == null) return null;

        client.setEstado(true);

        return repo.save(client);
    }
}

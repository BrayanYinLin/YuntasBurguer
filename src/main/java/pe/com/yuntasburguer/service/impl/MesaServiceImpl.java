package pe.com.yuntasburguer.service.impl;

import java.util.List;
import java.util.Optional; // Necesario para el Optional

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.yuntasburguer.entity.Mesa;
import pe.com.yuntasburguer.entity.Mesa.EstadoMesa; // Importa tu Enum
import pe.com.yuntasburguer.repository.MesaRepository;
import pe.com.yuntasburguer.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {
    
    @Autowired
    private MesaRepository repo;

    @Override
    public List<Mesa> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Mesa> findLibres() {
        // Asegúrate de que este método exista en tu Repository como vimos antes
        return repo.findLibres(); 
    }

    @Override
    public Mesa findById(Integer id) { // CORREGIDO: Long -> Integer
        return repo.findById(id).orElse(null);
    }

    @Override
    public Mesa add(Mesa obj) {
        return repo.save(obj);
    }

    @Override
    public Mesa update(Mesa obj, Integer id) { 

        Optional<Mesa> mesaExistente = repo.findById(id);

        if (mesaExistente.isPresent()) {
            Mesa mesaDB = mesaExistente.get();


            mesaDB.setNumero(obj.getNumero());
            mesaDB.setEstado(obj.getEstado()); 

            return repo.save(mesaDB);
        }
        return null; 

    }

 

	@Override
	public Mesa delete(Integer id) {
		 Mesa mesaDB = repo.findById(id).orElse(null);
	        if (mesaDB != null) {
	            mesaDB.setEstado(EstadoMesa.Inactiva); 
	            return repo.save(mesaDB);
	        }
	        return null;
	}

	@Override
	public Mesa enable(Integer id) {
		 Mesa mesaDB = repo.findById(id).orElse(null);
	        if (mesaDB != null) {
	            mesaDB.setEstado(EstadoMesa.Libre);
	            return repo.save(mesaDB);
	        }
	        return null;
	}

	@Override
	public Mesa ocuparMesa(Integer id) {
		 Mesa mesaDB = repo.findById(id).orElse(null);
	        if (mesaDB != null) {
	            mesaDB.setEstado(EstadoMesa.Ocupada);
	            return repo.save(mesaDB);
	        }
	        return null;
	}
	
}
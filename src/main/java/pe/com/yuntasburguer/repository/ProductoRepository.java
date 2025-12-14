package pe.com.yuntasburguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.yuntasburguer.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	 @Query("SELECT po FROM Producto po WHERE po.estado = true")
	    List<Producto> findAllCustom();
}

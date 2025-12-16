package pe.com.yuntasburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.yuntasburguer.service.DetallePedidoService;
import pe.com.yuntasburguer.service.ProductoService;

@Controller
@RequestMapping("/")
public class DetallePedidoController {
	
	@Autowired
	private DetallePedidoService servicio;
	
	@Autowired
	private ProductoService serpro;
	
	

}

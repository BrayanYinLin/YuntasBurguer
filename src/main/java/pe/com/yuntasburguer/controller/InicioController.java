package pe.com.yuntasburguer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/iniciosesion")
    public String MostrarInicioSesion() {
        return "iniciosesion";
    }
    @GetMapping("/menu")
    public String MostarMenuMantenimiento() {
        return "menumantenimiento";
    }
    
}

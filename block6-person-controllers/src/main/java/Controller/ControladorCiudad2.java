package Controller;

import Model.Ciudad;
import Service.ServicioCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class ControladorCiudad2 {

    @Autowired
    private ServicioCiudad servicioCiudad;

    @GetMapping("/getCiudades")
    public List<Ciudad> getCiudades() {
        return servicioCiudad.getCiudades();
    }
}

package Controller;

import Model.Ciudad;
import Service.ServicioCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class ControladorCiudad {

    @Autowired
    private ServicioCiudad servicioCiudad;

    @PostMapping("/addCiudad")
    public void addCiudad(@RequestBody Ciudad ciudad) {
        servicioCiudad.addCiudad(ciudad);
        System.out.println(ciudad);
    }
}

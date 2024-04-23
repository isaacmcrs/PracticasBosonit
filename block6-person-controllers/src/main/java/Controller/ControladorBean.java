package Controller;
import Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador")
public class ControladorBean {

    @Autowired
    @Qualifier("bean1")
    private Persona bean1;

    @Autowired
    @Qualifier("bean2")
    private Persona bean2;

    @Autowired
    @Qualifier("bean3")
    private Persona bean3;

    @GetMapping("/bean/{bean}")
    public Persona getBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return bean1;
            case "bean2":
                return bean2;
            case "bean3":
                return bean3;
            default:
                return null;
        }
    }
}

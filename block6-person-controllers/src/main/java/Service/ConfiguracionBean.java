package Service;

import Model.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionBean {

    @Bean(name = "bean1")
    public Persona personaBean1() {
        return new Persona("Hola soy bean1", "Toledo", 11);
    }

    @Bean(name = "bean2")
    public Persona personaBean2() {
        return new Persona("Hola soy bean2", "Guadalajara", 22);
    }

    @Bean(name = "bean3")
    public Persona personaBean3() {
        return new Persona("Hola soy bean3", "albacete", 33);
    }
}
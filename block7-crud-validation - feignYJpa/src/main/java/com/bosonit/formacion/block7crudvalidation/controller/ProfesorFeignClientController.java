package com.bosonit.formacion.block7crudvalidation.controller;
import com.bosonit.formacion.block7crudvalidation.clase.ProfesorFeignClient;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/persona")
public class ProfesorFeignClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProfesorFeignClient profesorFeignClient;

    @GetMapping("/profesor/resttemplate/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesorUsingRestTemplate(@PathVariable long id) {
        String url = "http://localhost:8081/profesor/" + id;
        ProfesorOutputDTO profesorOutputDTO = restTemplate.getForObject(url, ProfesorOutputDTO.class);
        return ResponseEntity.ok(profesorOutputDTO);
    }

    @GetMapping("/profesor/feign/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesorUsingFeign(@PathVariable long id) {
        ProfesorOutputDTO profesorOutputDTO = profesorFeignClient.getProfesor(id);
        return ResponseEntity.ok(profesorOutputDTO);
    }
}
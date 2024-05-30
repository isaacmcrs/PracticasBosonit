package com.bosonit.formacion.block7crudvalidation.clase;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "profesor-service", url = "http://localhost:8081")
public interface ProfesorFeignClient {
    @GetMapping("/profesor/{id}")
    ProfesorOutputDTO getProfesor(@PathVariable("id") long id);
}
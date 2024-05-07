package com.block6personcontrollers.Service;

import com.block6personcontrollers.Model.Ciudad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCiudad {
    private List<Ciudad> ciudades = new ArrayList<>();

    public void addCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
        System.out.println(ciudad);
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
}
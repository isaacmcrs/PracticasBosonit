package com.bosonit.formacion.Maven.block5profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Block5ProfilesApplication {


	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

}
@Component
class MyCommandLineRunner implements CommandLineRunner {
	@Autowired
	ClaseInterface clase1;
	@Autowired
	Environment environment;

	@Value("${propiedad1}")
	private String propiedad1;

	@Value("${propiedad2}")
	private String propiedad2;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Propiedad 1: " + propiedad1);
		System.out.println("Propiedad 2: " + propiedad2);
		System.out.println("Clase1: " + clase1.saluda());
	}
}

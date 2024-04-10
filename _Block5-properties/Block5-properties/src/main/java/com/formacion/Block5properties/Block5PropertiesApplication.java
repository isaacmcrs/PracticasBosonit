package com.formacion.Block5properties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.List;

@SpringBootApplication
public class Block5PropertiesApplication {


	final Clase1 clase1;

	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private int myNumber;


	@Value("${new.property: new.property no tiene valor}")
	private String newProperty;

	@Value("${MYURL: No se encontró la variable MYURL}")
	private String MYURL;

	@Value("${MYURL2: NO_tengo_valor}")
	private String myUrl2;

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
		//new Block5PropertiesApplication();
	}
	public Block5PropertiesApplication(Clase1 clase1)
	{
		this.clase1=clase1;
		//this.clase1=clase1;
		//clase1.saludame();
	}
	@Bean
	@Order(2)
	CommandLineRunner ejectuar()
	{
		return (args) ->
		{
			System.out.println("El valor de greeting es: " + greeting);
			System.out.println("El valor de my.number es: " + myNumber);
			System.out.println("El valor de new.property es: " + newProperty);
			System.out.println("El valor de la variable de entorno MYURL es: " + MYURL);
			System.out.println("El valor de la variable de entorno MYURL2 es: " + myUrl2);
			System.out.println("Valor de saludame es: " + clase1.saludame());
			System.out.println("Valor del usuario es:: " + clase1.getUsuario());

		};
	}
	@PostConstruct
	void afterDead()
	{
		System.out.println("Me han construido!!!");
	}

}


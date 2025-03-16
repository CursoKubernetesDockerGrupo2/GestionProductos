package com.netec.GestionProductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class GestionProductosApplication {

	private static final Logger logger = Logger.getLogger(GestionProductosApplication.class.getName());

	public static void main(String[] args) {
		logger.log(Level.INFO, "Bienvenidos a GestionProductos - Grupo 2");
		SpringApplication.run(GestionProductosApplication.class, args);
	}

}

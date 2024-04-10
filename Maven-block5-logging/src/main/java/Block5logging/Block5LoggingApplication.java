package Block5logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Block5LoggingApplication {

	private static final Logger logger = Logger.getLogger(Block5LoggingApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(Block5LoggingApplication.class, args);

		configureLogger();

		logger.severe("Este es un mensaje de error");
		logger.warning("Este es un mensaje de advertencia");
		logger.info("Este es un mensaje informativo");
		logger.config("Este es un mensaje de configuración");
		logger.fine("Este es un mensaje detallado");
		logger.finer("Este es un mensaje aún más detallado");
		logger.finest("Este es el mensaje más detallado posible");
	}

	private static void configureLogger() {
		try {
			// Especifica la ruta y el nombre del archivo de registro
			String logFilePath = "error.log";

			// Crea un nuevo FileHandler con la ruta del archivo de registro
			FileHandler fileHandler = new FileHandler(logFilePath, true); // true indica que se añadirá al archivo en lugar de sobrescribirlo

			// Configura el nivel de registro para el FileHandler
			fileHandler.setLevel(Level.SEVERE); // Registra solo mensajes de error

			// Añade el FileHandler al logger
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			// Maneja cualquier excepción que pueda ocurrir al crear el FileHandler
			e.printStackTrace();
		}
	}
}

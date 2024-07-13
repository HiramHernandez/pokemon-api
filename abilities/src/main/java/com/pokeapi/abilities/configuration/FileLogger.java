package com.pokeapi.abilities.configuration;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
    public static void configure() {
        // Obtener el logger raíz
        String fileName = "logs.txt";
        Logger logger = Logger.getLogger(fileName);

        try {
            // Configurar un FileHandler para redirigir los logs a un archivo
            FileHandler fileHandler = new FileHandler(fileName);
            fileHandler.setFormatter(new SimpleFormatter());

            // Establecer el nivel de log a ALL (o al nivel deseado)
            logger.setLevel(Level.ALL);

            // Agregar el FileHandler al logger
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desactivar la salida en consola
        logger.setUseParentHandlers(false);
    }
}

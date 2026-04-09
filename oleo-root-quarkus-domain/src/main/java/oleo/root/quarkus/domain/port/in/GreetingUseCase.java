package oleo.root.quarkus.domain.port.in;

import oleo.root.quarkus.domain.model.Greeting;

/**
 * Puerto de entrada para el servicio de saludos.
 */
public interface GreetingUseCase {
    /**
     * Genera un saludo para el nombre proporcionado.
     *
     * @param name Nombre a saludar.
     * @return Modelo de saludo con el mensaje generado.
     */
    Greeting greet(String name);
}

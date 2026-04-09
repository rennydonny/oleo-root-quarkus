package oleo.root.quarkus.infrastructure.rest;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import oleo.root.quarkus.domain.model.Greeting;
import oleo.root.quarkus.domain.port.in.GreetingUseCase;

/**
 * Adaptador REST que utiliza hilos virtuales.
 */
@Path("/hello")
public class GreetingResource {

    private final GreetingUseCase greetingUseCase;

    /**
     * Constructor con inyección de dependencias.
     * @param greetingUseCase Caso de uso de saludos.
     */
    @Inject
    public GreetingResource(final GreetingUseCase greetingUseCase) {
        this.greetingUseCase = greetingUseCase;
    }

    /**
     * Endpoint que corre sobre hilos virtuales.
     * @param name Nombre a saludar.
     * @return Mensaje de saludo.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public Greeting hello(@QueryParam("name") final String name) {
        return greetingUseCase.greet(name);
    }
}
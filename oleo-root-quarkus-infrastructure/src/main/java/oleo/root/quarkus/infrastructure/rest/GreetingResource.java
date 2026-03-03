package oleo.root.quarkus.infrastructure.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import oleo.root.quarkus.domain.service.GreetingService;

@Path("/hello")
public class GreetingResource {
    
    private final GreetingService greetingService = new GreetingService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        return greetingService.greet(name);
    }
}
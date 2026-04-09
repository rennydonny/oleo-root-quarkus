package oleo.root.quarkus.domain.event;

import java.time.Instant;

/**
 * Evento que indica la creación de un saludo.
 */
public record GreetingCreated(String message, Instant occurredAt) implements DomainEvent {
    /**
     * Factory method para crear un evento de saludo.
     * @param message Mensaje del saludo.
     * @return GreetingCreated.
     */
    public static GreetingCreated now(String message) {
        return new GreetingCreated(message, Instant.now());
    }
}

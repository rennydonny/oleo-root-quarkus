package oleo.root.quarkus.domain.event;

import java.time.Instant;

/**
 * Interfaz base para todos los eventos de dominio.
 * Refleja un hecho que ya ocurrió en el negocio.
 */
public interface DomainEvent {
    /**
     * Momento en que ocurrió el evento.
     * @return Instant.
     */
    Instant occurredAt();
}

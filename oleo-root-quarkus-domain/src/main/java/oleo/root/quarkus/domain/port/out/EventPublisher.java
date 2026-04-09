package oleo.root.quarkus.domain.port.out;

import oleo.root.quarkus.domain.event.DomainEvent;

/**
 * Puerto de salida para la publicación de eventos de dominio.
 */
public interface EventPublisher {
    /**
     * Publica un evento de dominio.
     * @param event Evento a publicar.
     */
    void publish(DomainEvent event);
}

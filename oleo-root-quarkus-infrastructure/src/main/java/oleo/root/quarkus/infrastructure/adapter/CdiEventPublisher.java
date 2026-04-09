package oleo.root.quarkus.infrastructure.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import oleo.root.quarkus.domain.event.DomainEvent;
import oleo.root.quarkus.domain.port.out.EventPublisher;

/**
 * Implementación del publicador de eventos usando el bus de eventos de CDI (Quarkus).
 */
@ApplicationScoped
public class CdiEventPublisher implements EventPublisher {

    private final Event<DomainEvent> eventBus;

    @Inject
    public CdiEventPublisher(Event<DomainEvent> eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publish(DomainEvent event) {
        eventBus.fire(event);
    }
}

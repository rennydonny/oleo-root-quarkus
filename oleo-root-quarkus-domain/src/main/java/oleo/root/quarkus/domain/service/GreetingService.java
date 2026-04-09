package oleo.root.quarkus.domain.service;

import oleo.root.quarkus.domain.event.GreetingCreated;
import oleo.root.quarkus.domain.model.Greeting;
import oleo.root.quarkus.domain.model.GuestName;
import oleo.root.quarkus.domain.port.in.GreetingUseCase;
import oleo.root.quarkus.domain.port.out.EventPublisher;

/**
 * Servicio de dominio agnóstico de framework.
 */
public class GreetingService implements GreetingUseCase {

    private final EventPublisher eventPublisher;

    public GreetingService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Greeting greet(String name) {
        final var guestName = GuestName.of(name);
        final var greeting = Greeting.from(guestName);

        eventPublisher.publish(GreetingCreated.now(greeting.message()));

        return greeting;
    }
}
package oleo.root.quarkus.domain.service;

import oleo.root.quarkus.domain.event.GreetingCreated;
import oleo.root.quarkus.domain.model.Greeting;
import oleo.root.quarkus.domain.port.in.GreetingUseCase;
import oleo.root.quarkus.domain.port.out.EventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private GreetingUseCase service;
    private final List<Object> publishedEvents = new ArrayList<>();

    @BeforeEach
    void setUp() {
        EventPublisher publisher = publishedEvents::add;
        service = new GreetingService(publisher);
        publishedEvents.clear();
    }

    @Test
    @DisplayName("Should greet and publish event")
    void shouldGreetAndPublishEvent() {
        Greeting result = service.greet("Renny");

        assertThat(result.message()).isEqualTo("Hola Renny");
        assertThat(publishedEvents).hasSize(1);
        assertThat(publishedEvents.getFirst()).isInstanceOf(GreetingCreated.class);
        GreetingCreated event = (GreetingCreated) publishedEvents.getFirst();
        assertThat(event.message()).isEqualTo("Hola Renny");
    }

    @Test
    @DisplayName("Should greet with default when name is empty")
    void shouldGreetWithDefaultWhenNameIsEmpty() {
        Greeting result = service.greet("");

        assertThat(result.message()).isEqualTo("Hola Mundo");
        assertThat(publishedEvents).hasSize(1);
    }
}
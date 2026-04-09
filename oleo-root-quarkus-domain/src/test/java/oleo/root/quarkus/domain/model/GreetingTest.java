package oleo.root.quarkus.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingTest {

    @Test
    @DisplayName("Should create localized greeting based on name")
    void shouldCreateLocalizedGreeting() {
        var name = GuestName.of("Renny");
        var greeting = Greeting.from(name);

        assertThat(greeting.message()).isEqualTo("Hola Renny");
    }

    @Test
    @DisplayName("Should create default greeting when name is default")
    void shouldCreateDefaultGreeting() {
        var name = GuestName.of(null);
        var greeting = Greeting.from(name);

        assertThat(greeting.message()).isEqualTo("Hola Mundo");
    }
}

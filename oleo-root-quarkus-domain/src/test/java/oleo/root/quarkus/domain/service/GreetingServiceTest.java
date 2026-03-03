package oleo.root.quarkus.domain.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {
    @Test
    void testGreet() {
        GreetingService service = new GreetingService();
        assertEquals("Hola Renny", service.greet("Renny"));
        assertEquals("Hola Mundo", service.greet(null));
        assertEquals("Hola Mundo", service.greet(" "));
    }
}
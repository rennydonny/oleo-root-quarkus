package oleo.root.quarkus.infrastructure.rest;

import io.quarkus.test.junit.QuarkusTest;
import oleo.root.quarkus.domain.event.GreetingCreated;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.event.Observes;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class GreetingResourceTest {

    private static final List<GreetingCreated> EVENTS = new CopyOnWriteArrayList<>();

    void onGreetingCreated(@Observes GreetingCreated event) {
        EVENTS.add(event);
    }

    @Test
    void testHelloEndpoint() {
        EVENTS.clear();
        given()
          .when().get("/hello?name=Renny")
          .then()
             .statusCode(200)
             .body("message", is("Hola Renny"));
        
        assertThat(EVENTS).hasSize(1);
        assertThat(EVENTS.get(0).message()).isEqualTo("Hola Renny");
    }
    
    @Test
    void testHelloEndpointEmpty() {
        EVENTS.clear();
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body("message", is("Hola Mundo"));
        
        assertThat(EVENTS).hasSize(1);
    }
}
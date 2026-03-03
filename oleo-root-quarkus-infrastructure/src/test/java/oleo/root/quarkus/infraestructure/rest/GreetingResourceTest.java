package oleo.root.quarkus.infrastructure.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello?name=Renny")
          .then()
             .statusCode(200)
             .body(is("Hola Renny"));
    }
    
    @Test
    void testHelloEndpointEmpty() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hola Mundo"));
    }
}
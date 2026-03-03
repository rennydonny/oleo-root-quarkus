package oleo.root.quarkus.domain.service;

public class GreetingService {
    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hola Mundo";
        }
        return "Hola " + name.trim();
    }
}
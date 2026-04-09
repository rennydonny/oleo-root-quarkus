package oleo.root.quarkus.domain.model;

/**
 * Entidad de dominio (representada como record para inmutabilidad) que encapsula un saludo.
 */
public record Greeting(String message) {

    private static final String GREETING_PREFIX = "Hola ";

    /**
     * Factory method para crear un saludo a partir de un GuestName.
     * @param guestName Nombre del invitado.
     * @return Instancia de Greeting.
     */
    public static Greeting from(GuestName guestName) {
        return new Greeting(GREETING_PREFIX + guestName.value());
    }
}

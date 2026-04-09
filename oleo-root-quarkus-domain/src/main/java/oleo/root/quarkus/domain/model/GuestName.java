package oleo.root.quarkus.domain.model;

import java.util.Objects;

/**
 * Value Object que representa el nombre de un invitado.
 * Aplica validaciones de negocio y garantiza la inmutabilidad.
 */
public record GuestName(String value) {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 30;
    private static final String DEFAULT_NAME = "Mundo";

    /**
     * Factory method para crear un GuestName con validaciones.
     * @param name Nombre del invitado.
     * @return Instancia de GuestName.
     */
    public static GuestName of(String name) {
        final var sanitized = (name == null || name.isBlank()) ? DEFAULT_NAME : name.trim();
        validate(sanitized);
        return new GuestName(sanitized);
    }

    private static void validate(String name) {
        if (!DEFAULT_NAME.equals(name) && (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH)) {
            throw new IllegalArgumentException(
                String.format("El nombre debe tener entre %d y %d caracteres (longitud actual: %d)",
                    MIN_LENGTH, MAX_LENGTH, name.length())
            );
        }
    }

    /**
     * Constructor compacto para validación adicional si se usa el constructor directo.
     */
    public GuestName {
        Objects.requireNonNull(value, "El valor no puede ser nulo");
    }
}

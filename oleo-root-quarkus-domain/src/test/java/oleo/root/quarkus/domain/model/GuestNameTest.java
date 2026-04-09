package oleo.root.quarkus.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GuestNameTest {

    @Test
    @DisplayName("Should create GuestName when value is valid")
    void shouldCreateGuestNameWhenValueIsValid() {
        var name = "Juan";
        var guestName = GuestName.of(name);
        assertThat(guestName.value()).isEqualTo("Juan");
    }

    @Test
    @DisplayName("Should return 'Mundo' when name is null or blank")
    void shouldReturnDefaultWhenNameIsInvalid() {
        assertThat(GuestName.of(null).value()).isEqualTo("Mundo");
        assertThat(GuestName.of("").value()).isEqualTo("Mundo");
        assertThat(GuestName.of("   ").value()).isEqualTo("Mundo");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab", "EstaEsUnaCadenaMuyLargaQueSuperaLosTreintaCaracteres"})
    @DisplayName("Should throw exception when name length is invalid")
    void shouldThrowExceptionWhenNameLengthIsInvalid(String invalidName) {
        assertThatThrownBy(() -> GuestName.of(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("longitud");
    }
}

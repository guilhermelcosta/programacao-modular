package classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelogioTest {

    @Test
    @DisplayName("Validar hora")
    void validarHora() {
        assertEquals(10, Relogio.validarHora(20, 40, 30));
    }

}
import classes.Relogio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RelogioTest {

    @Test
    @DisplayName("Validar hora")
    void validarHora() {
        assertTrue(Relogio.validarHora(27, 40, 30));
    }

}

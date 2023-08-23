import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelogioTest {

    @Test
    @DisplayName("Validar hora")
    void validarHora() {
        assertEquals(10, validarHora("20:59:39"));
    }
}

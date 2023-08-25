package classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class RelogioTest {

    private final Relogio relogio = new Relogio();

    @Test
    @DisplayName("Validar construtor com hora correta")
    public void testeConstrutor_Correto() throws Exception {
        new Relogio(23, 30, 45);
    }

    @Test
    @DisplayName("Validar construtor com hora incorreta")
    public void testeConstrutor_Incorreto() {
        assertThrows(Exception.class, () -> {
            new Relogio(25, 30, 45);
        });
    }

    @Test
    @DisplayName("Validar hora correta")
    void testeValidarHora_True() {
        assertTrue(Relogio.validarHora(19, 33, 27));
    }

    @Test
    @DisplayName("Validar hora incorreta")
    void testeValidarHora_False() {
        assertFalse(Relogio.validarHora(25, 45, 30));
    }

    @Test
    @DisplayName("Validar hora relogio apos reinicio")
    public void testeReiniciarRelogio() {
        relogio.setHora(12);
        relogio.setMin(30);
        relogio.setSeg(45);
        relogio.reiniciarRelogio();
        assertEquals(0, relogio.getHora());
        assertEquals(0, relogio.getMin());
        assertEquals(0, relogio.getSeg());
    }

    @Test
    @DisplayName("Validar hora conforme SO")
    public void testeAtualizarHoraAtual() {
        relogio.atualizarHoraAtual();
        assertEquals(relogio.getHora(), LocalTime.now().getHour());
        assertEquals(relogio.getMin(), LocalTime.now().getMinute());
        assertEquals(relogio.getSeg(), LocalTime.now().getSecond());
    }

}

package classes;

public class Relogio {

    private int hora;
    private int min;
    private int seg;

    public static boolean validarHora(int hora, int min, int seg) {
        return hora >= 0 && hora < 24 && min >= 0 && min < 60 && seg >= 0 && seg < 60;
    }

}

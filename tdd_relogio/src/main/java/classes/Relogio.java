package classes;

import java.time.LocalTime;

public class Relogio {

    private static int hora;
    private static int min;
    private static int seg;

    public Relogio(int hora, int min, int seg) throws Exception {

        if (validarHora(hora, min, seg)) {
            Relogio.hora = hora;
            Relogio.min = min;
            Relogio.seg = seg;
        } else
            throw new Exception("Hora invalida!");
    }

    public Relogio() {
        hora = 0;
        min = 0;
        seg = 0;
    }

    public static boolean validarHora(int hora, int min, int seg) {
        return (hora >= 0 && hora < 24) && (min >= 0 && min < 60) && (seg >= 0 && seg < 60);
    }

    public void reiniciarRelogio() {
        hora = 0;
        min = 0;
        seg = 0;
    }

    public void atualizarHoraAtual() {
        hora = LocalTime.now().getHour();
        min = LocalTime.now().getMinute();
        seg = LocalTime.now().getSecond();
    }

    public void cronometrarIntervalo(Relogio hora1, Relogio hora2) {

        Relogio fim = obterMaiorMenorHora(hora1, hora2);
        Relogio inicio = (fim == hora1) ? hora2 : hora1;

        int horaIntervalo = fim.getHora() - inicio.getHora();
        int minIntervalo = fim.getMin() - inicio.getMin();
        int segIntervalo = fim.getSeg() - inicio.getSeg();

        if (segIntervalo < 0) {
            minIntervalo--;
            segIntervalo += 60;
        }

        if (minIntervalo < 0) {
            horaIntervalo--;
            minIntervalo += 60;
        }
        System.out.printf("Intervalo: %02d:%02d:%02d\n", horaIntervalo, minIntervalo, segIntervalo);
    }

    private Relogio obterMaiorMenorHora(Relogio hora1, Relogio hora2) {

        if (hora1.getHora() > hora2.getHora())
            return hora1;

        if (hora1.getMin() > hora2.getMin())
            return hora1;

        return hora2;
    }

    public void imprimir(String tipoImpressao) throws Exception {

        switch (tipoImpressao) {
            case "24h" -> {
                System.out.printf("%02d:%02d:%02d\n", hora, min, seg);
            }
            case "AM/PM" -> {
                if (hora <= 12)
                    System.out.printf("%02d:%02d:%02d AM\n", hora, min, seg);
                else
                    System.out.printf("%02d:%02d:%02d PM\n", hora - 12, min, seg);
            }
            default -> throw new Exception("Opcao invalida");
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        Relogio.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        Relogio.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        Relogio.seg = seg;
    }
}

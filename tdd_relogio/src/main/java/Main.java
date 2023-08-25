import classes.Relogio;

public class Main {
    public static void main(String[] args) throws Exception {

        Relogio hora1 = new Relogio(12, 20, 30);
        Relogio hora2 = new Relogio(12, 50, 50);
        Relogio relogio = new Relogio();

        relogio.cronometrarIntervalo(hora1,hora2);
        hora2.atualizarHoraAtual();
        hora2.imprimir("AM/PM"); //valores aceitos: '24h' e 'AM/PM'

    }
}

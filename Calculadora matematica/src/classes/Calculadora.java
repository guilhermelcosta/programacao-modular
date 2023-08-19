package classes;

public class Calculadora {

    public Calculadora() {
    }

    public long calcular(String calculo, int num1, int num2) {

        switch (calculo) {

            case "adicao" -> {
                return num1 + num2;
            }

            case "subtracao" -> {
                return num1 - num2;
            }

            case "multiplicacao" -> {
                return (long) num1 * num2;
            }

            case "divisao" -> {
                return num1 / num2;
            }

            case "seno" -> {
                return (long) Math.sin(num1);
            }

            case "cosseno" -> {
                return (long) Math.cos(num1);
            }

            case "tangente" -> {
                return (long) Math.tan(num1);
            }

            case "raiz" -> {
                return (long) Math.sqrt(num1);
            }

            case "potencia" -> {
                return (long) Math.pow(num1, num2);
            }
            default -> throw new IllegalArgumentException("Opcao invalida!");
        }
    }
}

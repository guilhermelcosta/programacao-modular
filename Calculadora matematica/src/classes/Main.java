package classes;

import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) throws ScriptException {

        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.calcular("adicao", 1, 3));

    }
}

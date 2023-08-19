import classes.Estudante;
import classes.Turma;

public class Main {
    public static void main(String[] args) throws Exception {

        Estudante estudante01 = new Estudante("Jose", "20/04/1997");
        Estudante estudante02 = new Estudante("Pedro", "18/05/1999");
        Turma turma = new Turma();

        turma.adicionarEstudante(estudante01);
        turma.adicionarEstudante(estudante02);
        turma.removerEstudante(estudante01);
        turma.imprimir();

    }
}

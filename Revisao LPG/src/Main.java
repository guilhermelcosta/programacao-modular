public class Main {
    public static void main(String[] args) {

        Candidato candidato01 = new Candidato("Guilherme", new int[]{5, 0, 0, 3, 1});
        Candidato candidato02 = new Candidato("Lowrany", new int[]{1, 2, 3, 3, 2});

        candidato01.imprimir();
        Vaga vaga = new Vaga(new String[]{"Java", "Gerência de projetos"});
        vaga.imprimir();

        String[] hab = {"Java", "Front-end", "Python", "Back-end", "Gerência de projetos"};

        vaga.encontrarMelhorCandidato(new Candidato[]{candidato01, candidato02}, hab);

    }
}

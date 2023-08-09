import java.util.Arrays;

public class Vaga {

    public String[] habilidadesNecessarias;

    public Vaga(String[] habilidadesNecessarias) {
        this.habilidadesNecessarias = habilidadesNecessarias;
    }

    public void imprimir() {
        System.out.println("Habilidades necessárias -> " + Arrays.toString(habilidadesNecessarias));
    }

    public void encontrarMelhorCandidato(Candidato[] candidatos, String[] habilidadesNecessarias) {

        int melhorCandidato = 0;
        int somatorioHabilidadesNecessarias = 0;

        String[] habilidades = {"Java", "Front-end", "Python", "Back-end", "Gerência de projetos"};

        for (int i = 0; i < candidatos.length; i++) {

            int somatorioCandidato = 0;

            for (String habilidadeNecessaria : habilidadesNecessarias) {
                int posicao = Arrays.asList(habilidades).indexOf(habilidadeNecessaria);

                if (posicao != -1)
                    somatorioCandidato += candidatos[i].getHabilidades()[posicao];
            }

            if (somatorioCandidato > somatorioHabilidadesNecessarias) {
                somatorioHabilidadesNecessarias = somatorioCandidato;
                melhorCandidato = i;
            }
        }

        System.out.println("Melhor candidato: " + melhorCandidato);
    }
}

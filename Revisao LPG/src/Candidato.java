public class Candidato {

    public String nome;
    public int[] habilidades;

    public Candidato(String nome, int[] habilidades) {
        this.nome = nome;
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("Nome -> " + nome);
        String[] habilidades = {"Java", "Front-end", "Python", "Back-end", "Gerência de projetos"};

        for (int i = 0; i < habilidades.length; i++)
            System.out.println(habilidades[i] + " -> " + habilidades[i]);
        System.out.println("-------------------------");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(int[] habilidades) {
        this.habilidades = habilidades;
    }
}

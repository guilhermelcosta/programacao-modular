package classes;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private List<Estudante> listaEstudante;

    public Turma(List<Estudante> listaEstudante) {
        this.listaEstudante = listaEstudante;
    }

    public Turma() {
        this.listaEstudante = new ArrayList<>();
    }

    public void imprimir() {
        listaEstudante.forEach(Estudante::imprimir);
    }

    public void adicionarEstudante(Estudante estudante) throws Exception {

        if (verificarPosicaoEstudante(estudante) > 0)
            throw new Exception("Estudante ja cadastrado!");

        listaEstudante.add(estudante);
    }

    public void removerEstudante(Estudante estudante) throws Exception {

        if (verificarPosicaoEstudante(estudante) >= 0)
            listaEstudante.remove(estudante);
        else
            throw new Exception("Estudante nao cadastrado!");
    }

    private int verificarPosicaoEstudante(Estudante estudante) throws Exception {

        for (int i = 0; i < listaEstudante.size(); i++) {

            Estudante estudanteAtual = listaEstudante.get(i);

            if (estudanteAtual.getMatricula().equals(estudante.getMatricula()))
                return i;
        }
        return -1;
    }

    public List<Estudante> getListaEstudante() {
        return listaEstudante;
    }

    public void setListaEstudante(List<Estudante> listaEstudante) {
        this.listaEstudante = listaEstudante;
    }
}

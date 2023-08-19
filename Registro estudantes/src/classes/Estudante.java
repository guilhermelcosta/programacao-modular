package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Estudante {

    private String nome;
    private LocalDate dataNascimento;
    private UUID matricula;

    public Estudante(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.matricula = UUID.randomUUID();
    }

    public Estudante() {
        this.nome = "Nao informado";
        this.dataNascimento = LocalDate.of(1900, 1, 1);
        this.matricula = null;
    }

    public void imprimir() {
        System.out.println("\nNome               -> " + nome);
        System.out.println("Data de nascimento -> " + dataNascimento);
        System.out.println("Matricula          -> " + matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public UUID getMatricula() {
        return matricula;
    }

    public void setMatricula(UUID matricula) {
        this.matricula = matricula;
    }
}

package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paciente {

    private String nome;
    private String tipoSanguineo;
    private String[] alergias;
    private LocalDate dataNascimento;
    private List<Consulta> historicoConsultas = new ArrayList<>();

    public Paciente(String nome, String dataNascimento, String tipoSanguineo, String[] alergias) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
    }

    public Paciente() {
        this.nome = "Nao informado";
        this.dataNascimento = LocalDate.of(1900, 1, 1);
        this.tipoSanguineo = "Nao informado";
        this.alergias = new String[]{};
    }

    public void imprimir() {
        System.out.println("\nInformacoes do paciente------");
        System.out.println("Nome                      -> " + this.nome);
        System.out.println("Data de nascimento        -> " + this.dataNascimento);
        System.out.println("Tipo sanguineo            -> " + this.tipoSanguineo);
        System.out.println("Alergia                   -> " + Arrays.toString(this.alergias));
        System.out.println("Historico de consultas    -> ");
        this.historicoConsultas.forEach(Consulta::imprimir);
    }

    protected void adicionarConsultaHistorico(Consulta consulta) {
        this.historicoConsultas.add(consulta);
    }

    protected void removerConsultaHistorico(Consulta consulta) {
        this.historicoConsultas.remove(consulta);
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

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public void setAlergias(String[] alergias) {
        this.alergias = alergias;
    }

    public List<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public void setHistoricoConsultas(List<Consulta> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }
}

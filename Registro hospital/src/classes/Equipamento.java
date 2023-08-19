package classes;

import enums.StatusEquip;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Equipamento implements ItemEstoque {

    private int quantidade;
    private String nome;
    private String departamento;
    private LocalDate dataManutencao;
    private StatusEquip statusEquip;

    public Equipamento(int quantidade, String nome, String departamento, String dataManutencao, StatusEquip statusEquip) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.departamento = departamento;
        this.dataManutencao = LocalDate.parse(dataManutencao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.statusEquip = statusEquip;
    }

    public void imprimir() {
        System.out.println("\nNome                      -> " + this.nome);
        System.out.println("Departamento              -> " + this.departamento);
        System.out.println("Data manutencao           -> " + this.dataManutencao);
        System.out.println("Status do equipamento     -> " + this.statusEquip);
        System.out.println("Quantidade                -> " + this.quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public StatusEquip getStatusEquip() {
        return statusEquip;
    }

    public void setStatusEquip(StatusEquip statusEquip) {
        this.statusEquip = statusEquip;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

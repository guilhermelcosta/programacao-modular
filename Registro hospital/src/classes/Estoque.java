package classes;

import interfaces.ItemEstoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Estoque {

    private final List<Medicamento> listaMedicamentos;
    private final List<Equipamento> listaEquipamentos;

    public Estoque(List<Medicamento> listaMedicamentos, List<Equipamento> listaEquipamentos) {
        this.listaMedicamentos = listaMedicamentos;
        this.listaEquipamentos = listaEquipamentos;
    }

    public Estoque() {
        this.listaMedicamentos = new ArrayList<>();
        this.listaEquipamentos = new ArrayList<>();
    }

    public void imprimir() {
        System.out.println("\nEstoque--------------------");
        this.listaEquipamentos.forEach(Equipamento::imprimir);
        this.listaMedicamentos.forEach(Medicamento::imprimir);
    }

    public void atualizarEstoque(String atualizacao, ItemEstoque itemEstoque) throws Exception {

        switch (atualizacao) {
            case "adicionar_equipamento" -> {
                if (verificarInstancia(itemEstoque, Equipamento.class.getSimpleName()))
                    this.adicionarEquipamento((Equipamento) itemEstoque);
            }

            case "remover_equipamento" -> {
                if (verificarInstancia(itemEstoque, Equipamento.class.getSimpleName()))
                    this.removerEquipamento((Equipamento) itemEstoque);
            }

            case "adicionar_medicamento" -> {
                if (verificarInstancia(itemEstoque, Medicamento.class.getSimpleName()))
                    this.adicionarMedicamento((Medicamento) itemEstoque);
            }

            case "remover_medicamento" -> {
                if (verificarInstancia(itemEstoque, Medicamento.class.getSimpleName()))
                    this.removerMedicamento((Medicamento) itemEstoque);
            }

            default -> throw new IllegalArgumentException("Valor de atualizacao invalido!");
        }
    }

    private boolean verificarInstancia(ItemEstoque itemEstoque, String instancia) {

        if (itemEstoque.getClass().getSimpleName().equals(instancia))
            return true;

        throw new IllegalArgumentException("Instancia de objeto invalida!");
    }

    private void adicionarEquipamento(Equipamento novoEquipamento) {

        int posicaoNaLista = equipamentoExisteNaLista(novoEquipamento);

        if (posicaoNaLista >= 0) {
            Equipamento equipamento = listaEquipamentos.get(posicaoNaLista);
            equipamento.setQuantidade(equipamento.getQuantidade() + novoEquipamento.getQuantidade());
        } else
            listaEquipamentos.add(novoEquipamento);
    }

    private int equipamentoExisteNaLista(Equipamento novoEquipamento) {
        // Este metodo possui uma falha, caso sejam inseridos equipamentos com datas de manutencao ou status diferentes
        // eles sejam considerados 'mesmo equipamento' indiferentemente
        for (int i = 0; i < listaEquipamentos.size(); i++)
            if (Objects.equals(listaEquipamentos.get(i).getNome(), novoEquipamento.getNome()))
                return i;
        return -1;
    }

    private void removerEquipamento(Equipamento eq) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome -> " + eq.getNome() +  " | Estoque -> " + verificarEstoqueEquipamento(eq));
        System.out.print("Digite quanto deseja remover: ");

        int quantidadeRemover = scanner.nextInt();
        int posicaoNaLista = equipamentoExisteNaLista(eq);
        int quantidadeAtual = listaEquipamentos.get(posicaoNaLista).getQuantidade();

        if (quantidadeRemover > quantidadeAtual)
            throw new RuntimeException("Quantidade desejada para remover indisponivel!");

        Equipamento equipamento = listaEquipamentos.get(posicaoNaLista);

        if (quantidadeRemover == quantidadeAtual)
            listaEquipamentos.remove(equipamento);

        equipamento.setQuantidade(quantidadeAtual - quantidadeRemover);
    }

    private int verificarEstoqueEquipamento(Equipamento equipamento) throws Exception {

        int posicaoNaLista = equipamentoExisteNaLista(equipamento);

        if (posicaoNaLista >= 0) {
            int quantidade = listaEquipamentos.get(posicaoNaLista).getQuantidade();
            if (quantidade > 0)
                return quantidade;
        }
        throw new Exception("Equipamento fora de estoque!");
    }

    private void adicionarMedicamento(Medicamento novoMedicamento) {

        int posicaoNaLista = medicamentoExisteNaLista(novoMedicamento);

        if (posicaoNaLista >= 0) {
            Medicamento medicamento = listaMedicamentos.get(posicaoNaLista);
            medicamento.setQuantidade(medicamento.getQuantidade() + novoMedicamento.getQuantidade());
        } else
            listaMedicamentos.add(novoMedicamento);

    }

    private int medicamentoExisteNaLista(Medicamento novoMedicamento) {
        for (int i = 0; i < listaMedicamentos.size(); i++)
            if (Objects.equals(listaMedicamentos.get(i).getNome(), novoMedicamento.getNome()))
                return i;
        return -1;
    }

    private void removerMedicamento(Medicamento med) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Estoque do medicamento -> " + verificarEstoqueMedicamento(med));
        System.out.print("Digite quanto deseja remover: ");

        int quantidadeRemover = scanner.nextInt();
        int posicaoNaLista = medicamentoExisteNaLista(med);
        int quantidadeAtual = listaMedicamentos.get(posicaoNaLista).getQuantidade();

        if (quantidadeRemover > quantidadeAtual)
            throw new RuntimeException("Quantidade desejada para remover indisponivel!");

        Medicamento medicamento = listaMedicamentos.get(posicaoNaLista);

        medicamento.setQuantidade(quantidadeAtual - quantidadeRemover);
    }

    private int verificarEstoqueMedicamento(Medicamento medicamento) throws Exception {

        int posicaoNaLista = medicamentoExisteNaLista(medicamento);

        if (posicaoNaLista >= 0) {
            int quantidade = listaMedicamentos.get(posicaoNaLista).getQuantidade();
            if (quantidade > 0)
                return quantidade;
        }
        throw new Exception("Medicamento fora de estoque!");
    }
}
package classes;

<<<<<<< HEAD
import interfaces.ItemEstoque;

=======
>>>>>>> 519705ced93cd5358f0eaa0ec378809b959689a9
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicamento implements ItemEstoque {

    private int quantidade;
    private float dosagem;
    private String nome;
    private LocalDate validade;

    public Medicamento(int quantidade, String nome, float dosagem, String validade) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.validade = LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.quantidade = quantidade;
    }

    public void imprimir() {
        System.out.println("\nNome                      -> " + this.nome);
        System.out.println("Validade                  -> " + this.validade);
        System.out.println("Dosagem                   -> " + this.dosagem);
        System.out.println("Quantidade                -> " + this.quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDosagem() {
        return dosagem;
    }

    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

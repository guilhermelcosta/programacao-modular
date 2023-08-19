import classes.*;
import enums.StatusEquip;
import enums.TipoConsulta;

public class Main {
    public static void main(String[] args) throws Exception {

        Medico medico = new Medico("Cirurgiao geral", 10);
        Paciente paciente = new Paciente("Guilherme", "20/04/1997", "O-", new String[]{"A1", "A2"});
        Consulta consulta01 = new Consulta(TipoConsulta.AGENDADA, "18/04/2023", medico, paciente, new String[]{"M1", "M2"});
        Consulta consulta02 = new Consulta(TipoConsulta.EMERGENCIA, "20/04/2023", medico, paciente, new String[]{"M3", "M4"});

        consulta01.cancelarConsulta();
        consulta02.remarcarConsulta("27/04/2023");
        System.out.println("----------------------------------------");
        paciente.imprimir();
        medico.imprimir();

        Medicamento medicamento01 = new Medicamento(10, "Clenil", 200, "10/05/2023");
        Equipamento equipamento01 = new Equipamento(1, "Autoclave", "Saude", "10/02/2023", StatusEquip.DISPONIVEL);
        Equipamento equipamento02 = new Equipamento(5, "Cadeira", "Conforto", "10/02/2023", StatusEquip.DISPONIVEL);
        Estoque estoque = new Estoque();

        //        Opcoes para atualizacao do estoque: "adicionar_equipamento", "remover_equipamento", "adicionar_medicamento" e "remover_medicamento"

        estoque.atualizarEstoque("adicionar_equipamento", equipamento01);
        estoque.atualizarEstoque("adicionar_equipamento", equipamento02);
        estoque.atualizarEstoque("adicionar_medicamento", medicamento01);
        estoque.imprimir();
        System.out.println("----------------------------------------");
        estoque.atualizarEstoque("remover_equipamento", equipamento02);
        estoque.atualizarEstoque("remover_medicamento", medicamento01);
        estoque.imprimir();

    }
}

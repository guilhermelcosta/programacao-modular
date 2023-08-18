import classes.Consulta;
import classes.Medico;
import classes.Paciente;
import enums.TipoConsulta;

public class Main {
    public static void main(String[] args) throws Exception {

        Medico medico = new Medico("Cirurgiao geral", 10);
        medico.setNome("Roberto");

        Paciente paciente = new Paciente("Guilherme", "20/04/1997", "O-", new String[]{"A1", "A2"});
        Consulta consulta01 = new Consulta(TipoConsulta.AGENDADA, "18/04/2023", medico, paciente, new String[]{"M1", "M2"});
        Consulta consulta02 = new Consulta(TipoConsulta.AGENDADA, "20/04/2023", medico, paciente, new String[]{"M1", "M2"});

        consulta01.remarcarConsulta("27/07/2023");
        consulta02.cancelarConsulta();

        paciente.imprimir();
        medico.imprimir();
    }
}

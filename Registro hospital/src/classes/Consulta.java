package classes;

import enums.TipoConsulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Consulta {

    private TipoConsulta tipoConsulta;
    private LocalDate dataConsulta;
    private Medico medico;
    private String[] medicacoesEmUso;
    private Paciente paciente;

    public Consulta(TipoConsulta tipoConsulta, String dataConsulta, Medico medico, Paciente paciente, String[] medicacoesEmUso) throws RuntimeException {
        this.tipoConsulta = tipoConsulta;
        this.dataConsulta = marcarConsulta(tipoConsulta, dataConsulta, medico, paciente, medicacoesEmUso);
        this.medico = medico;
        this.paciente = paciente;
        this.medicacoesEmUso = medicacoesEmUso;
    }

    public Consulta() {
        this.tipoConsulta = null;
        this.dataConsulta = null;
        this.medico = null;
        this.paciente = null;
        this.medicacoesEmUso = null;
    }

    public void imprimir() {
        System.out.println("\nTipo da consulta          -> " + this.tipoConsulta);
        System.out.println("Data da consulta          -> " + this.dataConsulta);
        System.out.println("Medico responsavel        -> " + this.medico.getNome() + " - " + this.getMedico().getEspecialidade());
        System.out.println("Paciente                  -> " + this.paciente.getNome());
        System.out.println("Medicacoes em uso         -> " + Arrays.toString(this.medicacoesEmUso));
    }

    private LocalDate marcarConsulta(TipoConsulta tipoConsulta, String dataConsulta, Medico medico, Paciente paciente, String[] medicacoesEmUso) throws RuntimeException {

        List<LocalDate> calendarioConsultas = medico.getCalendarioConsultas();
        LocalDate novaDataConsulta = LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (!calendarioConsultas.contains(novaDataConsulta)) {
            medico.adicionarConsultaCalendario(dataConsulta);
            this.tipoConsulta = tipoConsulta;
            this.dataConsulta = novaDataConsulta;
            this.medico = medico;
            this.paciente = paciente;
            this.medicacoesEmUso = medicacoesEmUso;
            paciente.adicionarConsultaHistorico(this);

            System.out.println("\nConsulta marcada com sucesso!");
        } else throw new RuntimeException("Data da consulta nao disponivel");

        return novaDataConsulta;
    }

    public void remarcarConsulta(String dataConsulta) throws RuntimeException {

        List<LocalDate> calendarioConsultas = this.getMedico().getCalendarioConsultas();
        LocalDate novaDataConsulta = LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String novaDataConsultaString = novaDataConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dataConsultaAtualString = this.getDataConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Medico medico = this.getMedico();
        Paciente paciente = this.getPaciente();

        if (!calendarioConsultas.contains(novaDataConsulta)) {
            this.dataConsulta = marcarConsulta(this.getTipoConsulta(), novaDataConsultaString, this.getMedico(), this.getPaciente(), this.getMedicacoesEmUso());
            medico.removerConsultaCalendario(dataConsultaAtualString);
            paciente.removerConsultaHistorico(this);
        } else throw new RuntimeException("\nData da consulta nao disponivel");
    }

    public void cancelarConsulta() {
        String dataConsulta = this.getDataConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        medico.removerConsultaCalendario(dataConsulta);
        paciente.removerConsultaHistorico(this);
        System.out.println("\nConsulta cancelada com sucesso!");
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String[] getMedicacoesEmUso() {
        return medicacoesEmUso;
    }

    public void setMedicacoesEmUso(String[] medicacoesEmUso) {
        this.medicacoesEmUso = medicacoesEmUso;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

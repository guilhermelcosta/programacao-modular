package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Paciente {

    private String especialidade;
    private int anosExperiencia;
    private List<LocalDate> calendarioConsultas = new ArrayList<>();

    public Medico(String nome, String dataNascimento, String tipoSanguineo, String[] alergias, String especialidade, int anosExperiencia) {
        super(nome, dataNascimento, tipoSanguineo, alergias);
        this.especialidade = especialidade;
        this.anosExperiencia = anosExperiencia;
    }

    public Medico(String especialidade, int anosExperiencia) {
        this.especialidade = especialidade;
        this.anosExperiencia = anosExperiencia;
    }

    public void imprimir() {
        System.out.println("\nInformacoes do medico------");
        System.out.println("Especialidade             -> " + this.especialidade);
        System.out.println("Experiencia               -> " + this.anosExperiencia);
        System.out.println("Calendario                -> " + this.calendarioConsultas.toString());
    }

    protected void adicionarConsultaCalendario(String dataConsulta) {
        this.calendarioConsultas.add(LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    protected void removerConsultaCalendario(String dataConsulta) {
        this.calendarioConsultas.remove(LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public List<LocalDate> getCalendarioConsultas() {
        return calendarioConsultas;
    }

    public void setCalendarioConsultas(List<LocalDate> calendarioConsultas) {
        this.calendarioConsultas = calendarioConsultas;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.backend.logic;

/**
 *
 * @author ESCINF
 */
public class Diagnostico {
    Cita idCita;
    String signos;
    String diagnosticos;
    String medicina;
    Paciente paciente;

    public Diagnostico() {
    }

    public Diagnostico(Cita idCita, String signos, String diagnosticos, String medicina, Paciente paciente) {
        this.idCita = idCita;
        this.signos = signos;
        this.diagnosticos = diagnosticos;
        this.medicina = medicina;
        this.paciente = paciente;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public String getSignos() {
        return signos;
    }

    public void setSignos(String signos) {
        this.signos = signos;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getMedicina() {
        return medicina;
    }

    public void setMedicina(String medicina) {
        this.medicina = medicina;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Resultados {
    int id_cita;
    String signos;
    String diagnostico;
    String medicina;
    Paciente paciente;

    public Resultados() {
    }

    public Resultados(int id_cita, String signos, String diagnostico, String medicina, Paciente paciente) {
        this.id_cita = id_cita;
        this.signos = signos;
        this.diagnostico = diagnostico;
        this.medicina = medicina;
        this.paciente = paciente;
    }

    public Resultados(String signos, String diagnostico, String medicina, Paciente paciente) {
        this.signos = signos;
        this.diagnostico = diagnostico;
        this.medicina = medicina;
        this.paciente = paciente;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getSignos() {
        return signos;
    }

    public void setSignos(String signos) {
        this.signos = signos;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id_cita;
        hash = 47 * hash + Objects.hashCode(this.signos);
        hash = 47 * hash + Objects.hashCode(this.diagnostico);
        hash = 47 * hash + Objects.hashCode(this.medicina);
        hash = 47 * hash + Objects.hashCode(this.paciente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resultados other = (Resultados) obj;
        if (this.id_cita != other.id_cita) {
            return false;
        }
        if (!Objects.equals(this.signos, other.signos)) {
            return false;
        }
        if (!Objects.equals(this.diagnostico, other.diagnostico)) {
            return false;
        }
        if (!Objects.equals(this.medicina, other.medicina)) {
            return false;
        }
        return Objects.equals(this.paciente, other.paciente);
    }

    @Override
    public String toString() {
        return "Resultados{" + "id_cita=" + id_cita + ", signos=" + signos + ", diagnostico=" + diagnostico + ", medicina=" + medicina + ", paciente=" + paciente + '}';
    }
    
    
    
    
}

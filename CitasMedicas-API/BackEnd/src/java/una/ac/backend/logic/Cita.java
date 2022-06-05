/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Cita {
    int idCita;
    String estado;
    LocalDateTime fecha;
    String dateStr;
    String horaStr;
    Paciente paciente;
    Medico medico;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String DateStr) {
        this.dateStr = DateStr;
    }
    

    public Cita() {
        this.medico = new Medico();
        this.paciente = new Paciente();
    }

    public Cita(int idCita, String estado, LocalDateTime fecha,Paciente paciente, Medico medico) {
        this.idCita = idCita;
        this.estado = estado;
        this.fecha = fecha;
       
        this.paciente = paciente;
        this.medico = medico;
    }
    public Cita(int idCita, String estado, String fecha,String hora, Paciente paciente, Medico medico) {
        this.idCita = idCita;
        this.estado = estado;
        this.dateStr = fecha;
        this.horaStr = hora;
        this.paciente = paciente;
        this.medico = medico;
    }
    public Cita(String estado, String fecha,String hora, Paciente paciente, Medico medico) {

        this.estado = estado;
        this.dateStr = fecha;
        this.horaStr = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

    public String getHoraStr() {
        return horaStr;
    }

    public void setHoraStr(String horaStr) {
        this.horaStr = horaStr;
    }



    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idCita;
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.dateStr);
        hash = 37 * hash + Objects.hashCode(this.horaStr);
        hash = 37 * hash + Objects.hashCode(this.paciente);
        hash = 37 * hash + Objects.hashCode(this.medico);
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
        final Cita other = (Cita) obj;
        if (this.idCita != other.idCita) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.dateStr, other.dateStr)) {
            return false;
        }
        if (!Objects.equals(this.horaStr, other.horaStr)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return Objects.equals(this.medico, other.medico);
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", estado=" + estado + ", fecha=" + fecha + ", dateStr=" + dateStr + ", horaStr=" + horaStr + ", paciente=" + paciente + ", medico=" + medico + '}';
    }

 
    
}


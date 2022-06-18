/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

import java.time.LocalDateTime;

public class Cita {
    int idCita;
    String estado;
    String dateStr;
    String horaStr;
    String signo;
    String diagnostico;
    String medicina;
    Paciente paciente;
    Doctor medico;

            
    public Cita() {
    }

    public Cita(int idCita, String estado, String dateStr, String horaStr, String signo, String diagnostico, String medicina, Paciente paciente, Doctor medico) {
        this.idCita = idCita;
        this.estado = estado;
        this.dateStr = dateStr;
        this.horaStr = horaStr;
        this.signo = signo;
        this.diagnostico = diagnostico;
        this.medicina = medicina;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Cita(String estado, String dateStr, String horaStr, Paciente paciente, Doctor medico) {
        this.estado = estado;
        this.dateStr = dateStr;
        this.horaStr = horaStr;
        this.paciente = paciente;
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

    public String getFecha() {
        return dateStr;
    }

    public void setFecha(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
    
    
    public String getSigno() {
        return signo;
    }

    public void setSigno(String signos) {
        this.signo = signos;
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

    public Doctor getMedico() {
        return medico;
    }

    public void setMedico(Doctor medico) {
        this.medico = medico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idCita;
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
        return this.idCita == other.idCita;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", estado=" + estado + ", dateStr=" + dateStr + ", horaStr=" + horaStr + ", signo=" + signo + ", diagnostiico" + diagnostico + ", medicina" + medicina + ", paciente=" + paciente + ", medico=" + medico + '}';
    }
    
    //String signos, String diagnostico, String medicina,
    
}

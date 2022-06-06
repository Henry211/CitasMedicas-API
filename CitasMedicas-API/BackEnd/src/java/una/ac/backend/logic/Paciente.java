/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Paciente implements Serializable {
    String cedula;
    String nombre;
    String clave;
    String enfermedades;
    String alergias;
    String cirugias;
    String contacto_emergencia;
   
    

    public Paciente() {
    }

    public Paciente(String cedula, String nombre, String clave, String enfermedades, String alergias, String cirugias, String contacto_emergencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.enfermedades = enfermedades;
        this.alergias = alergias;
        this.cirugias = cirugias;
        this.contacto_emergencia = contacto_emergencia;
    }
    

    public Paciente(String cedula, String nombre, String clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
    }
    public Paciente(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }

   
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCirugias() {
        return cirugias;
    }

    public void setCirugias(String cirugias) {
        this.cirugias = cirugias;
    }

    public String getContacto_emergencia() {
        return contacto_emergencia;
    }

    public void setContacto_emergencia(String contacto_emergencia) {
        this.contacto_emergencia = contacto_emergencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.cedula);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.clave);
        hash = 47 * hash + Objects.hashCode(this.enfermedades);
        hash = 47 * hash + Objects.hashCode(this.alergias);
        hash = 47 * hash + Objects.hashCode(this.cirugias);
        hash = 47 * hash + Objects.hashCode(this.contacto_emergencia);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.enfermedades, other.enfermedades)) {
            return false;
        }
        if (!Objects.equals(this.alergias, other.alergias)) {
            return false;
        }
        if (!Objects.equals(this.cirugias, other.cirugias)) {
            return false;
        }
        return Objects.equals(this.contacto_emergencia, other.contacto_emergencia);
    }

    @Override
    public String toString() {
        return "Paciente{" + "cedula=" + cedula + ", nombre=" + nombre + ", clave=" + clave + ", enfermedades=" + enfermedades + ", alergias=" + alergias + ", cirugias=" + cirugias + ", contacto_emergencia=" + contacto_emergencia + '}';
    }
    
    
     
 
    
}


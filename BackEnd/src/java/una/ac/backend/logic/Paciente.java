/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

public class Paciente {

    String nombre;
    String cedula;
    String peso;
    String edad;
    String enfermedades;
    String alergias;
    String cirugias;
    String contacto_emergencia;

    public Paciente() {
    }
        
    
    public Paciente(String nombre, String cedula, String peso, String edad, String enfermedades, String alergias, String cirugias, String contacto_emergencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.peso = peso;
        this.edad = edad;
        this.enfermedades = enfermedades;
        this.alergias = alergias;
        this.cirugias = cirugias;
        this.contacto_emergencia = contacto_emergencia;
    }
        
    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    public Paciente(String cedula) {
        this.cedula=cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public void setAlergias(String Alergias) {
        this.alergias = Alergias;
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
    
    
    
}
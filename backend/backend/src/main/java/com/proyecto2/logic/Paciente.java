/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.logic;

/**
 *
 * @author ESCINF
 */
public class Paciente {
    String nombre;
    String cedula;
    String enfermedad;
    String Alergias;
    String cirugia;
    String contacEmergencia;

    public Paciente() {
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

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getAlergias() {
        return Alergias;
    }

    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }

    public String getCirugia() {
        return cirugia;
    }

    public void setCirugia(String cirugia) {
        this.cirugia = cirugia;
    }

    public String getContacEmergencia() {
        return contacEmergencia;
    }

    public void setContacEmergencia(String contacEmergencia) {
        this.contacEmergencia = contacEmergencia;
    }
    
    
    
}

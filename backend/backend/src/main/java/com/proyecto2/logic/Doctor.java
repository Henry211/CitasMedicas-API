/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.logic;

/**
 *
 * @author ESCINF
 */
public class Doctor {
    String nombre;
    String cedula;
    String password;
    String especialidad;
    String localidad;
    String tarifa;
    // Dia[] horario;

    public Doctor() {
    }

    public Doctor(String nombre, String cedula, String password, String especialidad, String localidad, String tarifa) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.password = password;
        this.especialidad = especialidad;
        this.localidad = localidad;
        this.tarifa = tarifa;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    
    
    /*
    public Dia[] getHorario() {
        return horario;
    }

    public void setHorario(Dia[] horario) {
        this.horario = horario;
    }

    */

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    
    
    
    
    
}
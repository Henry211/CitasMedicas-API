/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

/**
 *
 * @author ESCINF
 */
public class Doctor {
    String nombre;
    String id;
    String password;
    Especialidad especialidad;//objeto
    Ciudad localidad;//objeto
    String tarifa;
    // Dia[] horario;

    public Doctor() {
    }
    
    public Doctor(String id) {
        this.id = id;
    }


 

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Ciudad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Ciudad localidad) {
        this.localidad = localidad;
    }


   

    
    
    
    
    
}

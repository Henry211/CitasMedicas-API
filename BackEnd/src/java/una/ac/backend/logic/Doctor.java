/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

/**
 *
 * @author ESCINF
 */
public class Doctor extends Usuario{


    public String tipo;
    public String nombre;
    public String estado;
    public String id;
    public String password;
    public String especialidad;
    public String localidad;
    public String tarifa;
    // Dia[] horario;

    public Doctor() {
    }

    public Doctor(String tipo,String nombre, String estado, String id, String password, String especialidad, String localidad, String tarifa) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.estado = estado;
        this.id = id;
        this.password = password;
        this.especialidad = especialidad;
        this.localidad = localidad;
        this.tarifa = tarifa;
    }

        
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    
    
}
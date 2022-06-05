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
public class Especialidad implements Serializable{

    String especialidad;

    public Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.especialidad);
        return hash;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "especialidad=" + especialidad + '}';
    }
    

}
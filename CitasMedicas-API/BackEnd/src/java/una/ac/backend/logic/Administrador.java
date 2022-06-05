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
public class Administrador implements Serializable {
    String cedula;
    String nombre;
    String clave; 

    public Administrador() {
    }

    public Administrador(String cedula, String nombre, String clave) {
        this.cedula = cedula;
        this.nombre=nombre;
        this.clave = clave;
    }
    
    
    public Administrador(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.cedula);
        hash = 67 * hash + Objects.hashCode(this.clave);
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
        final Administrador other = (Administrador) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }

    @Override
    public String toString() {
        return "Administrador{" + "cedula=" + cedula + ", clave=" + clave + '}';
    }
    
    
    
}


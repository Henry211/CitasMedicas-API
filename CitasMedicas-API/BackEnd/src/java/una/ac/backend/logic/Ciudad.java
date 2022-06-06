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
public class Ciudad implements Serializable {

    String provincia;

    public Ciudad() {
    }

    public Ciudad(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.provincia);
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
        final Ciudad other = (Ciudad) obj;
        return Objects.equals(this.provincia, other.provincia);
    }
     
    
    @Override
    public String toString() {
        return "Ciudad{" + ", provincia=" + provincia + '}';
    }

}


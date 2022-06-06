/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESCINF
 */
public class Medico implements Serializable {

    String cedula;
    String nombre;
    String clave;
    String estado;
    int tarifa;
    Ciudad nombre_ciudad;
    Especialidad nombre_especialidad;
    //String foto;
    //Horario horario;
    ArrayList<String> citasGuardadas = new ArrayList<String>();
    //byte[] image = null;

    public Medico() {
    }

    public Medico(String cedula, String nombre, String clave) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        //this.image = new byte[]{0,0};

    }

    public Medico(String cedula, String nombre, String clave, String estado) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.estado = estado;
    }
    

    public Medico(String cedula, String nombre, String clave, String estado, int tarifa, Ciudad nombre_ciudad, Especialidad nombre_especialidad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.estado = estado;
        this.tarifa = tarifa;
        this.nombre_ciudad = nombre_ciudad;
        this.nombre_especialidad = nombre_especialidad;
    }
    
/*
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
*/

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public Ciudad getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(Ciudad nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public Especialidad getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(Especialidad nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }
    
    public ArrayList<String> getCitasGuardadas() {
        return citasGuardadas;
    }

    public void setCitasGuardadas(ArrayList<String> citasGuardadas) {
        this.citasGuardadas = citasGuardadas;
    }

    public void setCiudad(String c) {
        this.nombre_ciudad = new Ciudad(c);
    }

    public void setEspecialidad(String c) {
        this.nombre_especialidad = new Especialidad(c);
    }

    public Medico(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
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

    public String getClave() {
        return clave;
    }

    public Especialidad getEspecialidad() {
        return nombre_especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.nombre_especialidad = especialidad;
    }

    public Ciudad getCiudad() {
        return nombre_ciudad;
    }

    public void setCiudad(Ciudad nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
/*
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] imageArray) {
        this.image = imageArray;
    }
*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cedula);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.clave);
        hash = 71 * hash + Objects.hashCode(this.estado);
       // hash = 71 * hash + Objects.hashCode(this.foto);
        hash = 71 * hash + Objects.hashCode(this.nombre_ciudad);
        hash = 71 * hash + Objects.hashCode(this.nombre_especialidad);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        /*
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        */
        return Objects.equals(this.nombre_ciudad, other.nombre_ciudad);
    }
/*
    public String getBase64Image() {
        if(this.getImage() != null){
            try {
                String base64Image;
                try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        InputStream targetStream = new ByteArrayInputStream(this.getImage())) {
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = targetStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }   byte[] imageBytes = outputStream.toByteArray();
                    base64Image = Base64.getEncoder().encodeToString(imageBytes);
                }

                return base64Image;
            } catch (IOException ex) {
                Logger.getLogger(Especialidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "";
    }
*/

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

/**
 *
 * @author ESCINF
 */
public class Administrador {
   String nombre;
   String id;
   String clave;

    public Administrador() {
    }
   
   

    public Administrador(String nombre, String id, String clave) {
        this.nombre = nombre;
        this.id = id;
        this.clave = clave;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
   
   
   
    
}

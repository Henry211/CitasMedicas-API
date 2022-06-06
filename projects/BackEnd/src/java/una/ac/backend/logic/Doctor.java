package una.ac.backend.logic;

/**
 *
 * @author Henry
 */
public class Doctor {
    
    String cedula;
    String nombre;
    String clave;
    String especialidad;
    String fee;
    String localidad;
    //String horario;
    Dia[] horario;

    public Doctor(String cedula, String nombre, String clave, String estado, String horario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        
        //this.horario = horario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

   

   /* public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }*/
    
}

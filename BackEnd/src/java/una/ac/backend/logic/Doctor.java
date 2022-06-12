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

    public Doctor() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Dia[] getHorario() {
        return horario;
    }

    public void setHorario(Dia[] horario) {
        this.horario = horario;
    }

    public Doctor(String cedula, String clave, String nombre, String especialidad, String fee, String localidad/*, Dia[] horario*/ ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.especialidad = especialidad;
        this.fee = fee;
        this.localidad = localidad;
        //this.horario = horario;
    }

   /* public Doctor(String cedula, String nombre, String clave, String estado, String horario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        
        //this.horario = horario;
    }*/
    
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

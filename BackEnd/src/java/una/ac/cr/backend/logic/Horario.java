/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.backend.logic;

/**
 *
 * @author ESCINF
 */
public class Horario {


    String idDoctor;
    int id;
    boolean checked = false;
    String desde;
    String hasta;
    
    
    public Horario(){}
    public Horario(String idDoctor, int id,boolean checked, String desde, String hasta) {
        this.idDoctor = idDoctor;
        this.id = id;
        this.checked = checked;
        this.desde = desde;
        this.hasta = hasta;
    }

    
        
    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

 
    
    
    
            
            
    
}

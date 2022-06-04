/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.citasbackend.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class Service {
    
    private static Service uniqueInstance;
    
    
    public static Service instance(){
        if(uniqueInstance == null)
            uniqueInstance = new Service();
        return uniqueInstance;
    }
    
    HashMap<String, Doctor> doctores;
    
    private Service(){
        doctores = new HashMap<>();
    }
    
    
    
    
    public Doctor doctorCreate(Doctor doc) throws Exception{
        if(doctores.get(doc.getCedula()) !=  null){
            throw new Exception("406 - doctor ya existe");
        }else{
            doctores.put(doc.getCedula(),doc);
            return doc;
        }
    }
    
    public List<Doctor> doctoresRead(){
        return new ArrayList(doctores.values());
    }
    
    public Doctor doctorRead(String cedula) throws Exception{
        if(doctores.get(cedula) != null){
            return doctores.get(cedula);
        }else{
            throw new Exception ("404 - Persona no existe");
        }
    }
    
    public void doctorUpdate(Doctor doc) throws Exception{
        if(doctores.get(doc.getCedula()) == null){
            throw new Exception ("404- doctor no existe");
        }else{
            doctores.put(doc.getCedula(), doc);
        }
    }
    
    public void doctorDelete(String cedula) throws Exception{
        if(doctores.get(cedula) == null){
            throw new Exception ("404 - doctor no existe");
        }else{
            doctores.remove(cedula);
        }
    }
    
}

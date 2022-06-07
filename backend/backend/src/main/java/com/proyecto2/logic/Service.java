/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.logic;

/**
 *
 * @author ESCINF
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Service {

    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    HashMap<String,Doctor> personas;
    
    private Service(){
        personas = new HashMap<> ();
    }
    
    public Doctor personasCREATE(Doctor per)throws Exception {
        if (personas.get(per.getCedula())!=null){
            throw new Exception ("406-persona ya existe");
        }
        else{
            personas.put(per.getCedula(),per);
            return per;
        }
    }
    public List<Doctor> personasREAD() {
        return new ArrayList(personas.values());
    } 
    
    public Doctor personasREAD(String cedula)throws Exception {
        if (personas.get(cedula)!=null){
            return personas.get(cedula);
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }

    public void personasUPDATE(Doctor per)throws Exception {
        if (personas.get(per.getCedula())==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            personas.put(per.getCedula(), per);
        }
    }
    
    public void personasDELETE(String cedula)throws Exception {
        if (personas.get(cedula)==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            personas.remove(cedula);
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.logic;

/**
 *
 * @author ESCINF
 */
public class Horario {
    boolean checked;
    int desde;
    int hasta;

    public Horario(boolean checked, int desde, int hasta) {
        this.checked = checked;
        this.desde = desde;
        this.hasta = hasta;
    }
    
    

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }
    
    
    
            
            
    
}

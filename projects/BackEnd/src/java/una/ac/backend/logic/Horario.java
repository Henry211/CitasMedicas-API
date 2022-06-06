/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ESCINF
 */
public class Horario implements Serializable {

    ArrayList<String> lunes = new ArrayList<String>();
    int iniLunes, finLunes;
    ArrayList<String> martes = new ArrayList<String>();
    int iniMartes, finMartes;
    ArrayList<String> miercoles = new ArrayList<String>();
    int iniMiercoles, finMiercoles;
    ArrayList<String> jueves = new ArrayList<String>();
    int iniJueves, finJueves;
    ArrayList<String> viernes = new ArrayList<String>();
    int iniViernes, finViernes;
    ArrayList<String> sabado = new ArrayList<String>();
    int iniSabado, finSabado;

    int frecuencia;
    Medico medico = new Medico();

    public Horario(int iniLunes, int finLunes, int iniMartes, int finMartes, int iniMiercoles, int finMiercoles, int iniJueves, int finJueves, int iniViernes, int finViernes, int iniSabado, int finSabado, int frecuencia) {
        this.iniLunes = iniLunes;
        this.finLunes = finLunes;
        this.iniMartes = iniMartes;
        this.finMartes = finMartes;
        this.iniMiercoles = iniMiercoles;
        this.finMiercoles = finMiercoles;
        this.iniJueves = iniJueves;
        this.finJueves = finJueves;
        this.iniViernes = iniViernes;
        this.finViernes = finViernes;
        this.iniSabado = iniSabado;
        this.finSabado = finSabado;
        this.frecuencia = frecuencia;
    }

    ArrayList<String> horasDia = new ArrayList<String>();
    ArrayList<String> mediasHoras = new ArrayList<String>();

    public ArrayList<String> calcArrayHrs(int ini, int fin) {

        int tot, finAux;
        ArrayList<String> arreglo = new ArrayList<String>();
        tot = fin - ini;
        finAux = fin;

        if (frecuencia == 1) {

            for (int n = 0; n <= tot; n++) {
                arreglo.add(horasDia.get(finAux--));
            }
        }else if(frecuencia == 2){
            for (int n = 1; n <= tot; n++) {
                arreglo.add(mediasHoras.get(finAux--));
                arreglo.add(horasDia.get(finAux));
            }
        }

        return arreglo;
    }

    public void calcDias() {

        createArrayHoras();

        lunes = calcArrayHrs(iniLunes, finLunes);
        martes = calcArrayHrs(iniMartes, finMartes);
        miercoles = calcArrayHrs(iniMiercoles, finMiercoles);
        jueves = calcArrayHrs(iniJueves, finJueves);
        viernes = calcArrayHrs(iniViernes, finViernes);
        sabado = calcArrayHrs(iniSabado, finSabado);

    }

    public void createArrayHoras() {

        String a0 = "";
        String a1 = "1";
        String a2 = "2";
        String a3 = "3";
        String a4 = "4";
        String a5 = "5";
        String a6 = "6";
        String a7 = "7";
        String a8 = "08:00am";
        String a8m = "08:30am";
        String a9 = "09:00am";
        String a9m = "09:30am";
        String a10 = "10:00am";
        String a10m = "10:30am";
        String a11 = "11:00am";
        String a11m = "11:30am";
        String a12 = "12:00pm";
        String a12m = "12:30pm";
        String a13 = "1:00pm";
        String a13m = "1:30pm";
        String a14 = "2:00pm";
        String a14m = "2:30pm";
        String a15 = "3:00pm";
        String a15m = "3:30pm";
        String a16 = "4:00pm";
        String a16m = "4:30pm";
        String a17 = "5:00pm";
        String a17m = "5:30pm";
        String a18 = "6:00pm";
        String a18m = "6:30pm";

        this.horasDia = new ArrayList<String>();

        horasDia.add(a0);
        mediasHoras.add(a0);

        horasDia.add(a1);
        mediasHoras.add(a1);

        horasDia.add(a2);
        mediasHoras.add(a2);

        horasDia.add(a3);
        mediasHoras.add(a3);

        horasDia.add(a4);
        mediasHoras.add(a4);

        horasDia.add(a5);
        mediasHoras.add(a5);

        horasDia.add(a6);
        mediasHoras.add(a6);

        horasDia.add(a7);
        mediasHoras.add(a7);

        horasDia.add(a8);
        mediasHoras.add(a0);

        horasDia.add(a9);
        mediasHoras.add(a8m);

        horasDia.add(a10);
        mediasHoras.add(a9m);

        horasDia.add(a11);
        mediasHoras.add(a10m);

        horasDia.add(a12);
        mediasHoras.add(a11m);

        horasDia.add(a13);
        mediasHoras.add(a12m);

        horasDia.add(a14);
        mediasHoras.add(a13m);

        horasDia.add(a15);
        mediasHoras.add(a14m);

        horasDia.add(a16);
        mediasHoras.add(a15m);

        horasDia.add(a17);
        mediasHoras.add(a16m);

        horasDia.add(a18);
        mediasHoras.add(a17m);

    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public ArrayList<String> getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(ArrayList<String> horasDia) {
        this.horasDia = horasDia;
    }

    public int getIniLunes() {
        return iniLunes;
    }

    public void setIniLunes(int iniLunes) {
        this.iniLunes = iniLunes;
    }

    public int getFinLunes() {
        return finLunes;
    }

    public void setFinLunes(int finLunes) {
        this.finLunes = finLunes;
    }

    public int getIniMartes() {
        return iniMartes;
    }

    public void setIniMartes(int iniMartes) {
        this.iniMartes = iniMartes;
    }

    public int getFinMartes() {
        return finMartes;
    }

    public void setFinMartes(int finMartes) {
        this.finMartes = finMartes;
    }

    public int getIniMiercoles() {
        return iniMiercoles;
    }

    public void setIniMiercoles(int iniMiercoles) {
        this.iniMiercoles = iniMiercoles;
    }

    public int getFinMiercoles() {
        return finMiercoles;
    }

    public void setFinMiercoles(int finMiercoles) {
        this.finMiercoles = finMiercoles;
    }

    public int getIniJueves() {
        return iniJueves;
    }

    public void setIniJueves(int iniJueves) {
        this.iniJueves = iniJueves;
    }

    public int getFinJueves() {
        return finJueves;
    }

    public void setFinJueves(int finJueves) {
        this.finJueves = finJueves;
    }

    public int getIniViernes() {
        return iniViernes;
    }

    public void setIniViernes(int iniViernes) {
        this.iniViernes = iniViernes;
    }

    public int getFinViernes() {
        return finViernes;
    }

    public void setFinViernes(int finViernes) {
        this.finViernes = finViernes;
    }

    public int getIniSabado() {
        return iniSabado;
    }

    public void setIniSabado(int iniSabado) {
        this.iniSabado = iniSabado;
    }

    public int getFinSabado() {
        return finSabado;
    }

    public void setFinSabado(int finSabado) {
        this.finSabado = finSabado;
    }

    public Horario() {
    }

    public ArrayList<String> getLunes() {
        return lunes;
    }

    public void setLunes(ArrayList<String> lunes) {
        this.lunes = lunes;
    }

    public ArrayList<String> getMartes() {
        return martes;
    }

    public void setMartes(ArrayList<String> martes) {
        this.martes = martes;
    }

    public ArrayList<String> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(ArrayList<String> miercoles) {
        this.miercoles = miercoles;
    }

    public ArrayList<String> getJueves() {
        return jueves;
    }

    public void setJueves(ArrayList<String> jueves) {
        this.jueves = jueves;
    }

    public ArrayList<String> getViernes() {
        return viernes;
    }

    public void setViernes(ArrayList<String> viernes) {
        this.viernes = viernes;
    }

    public ArrayList<String> getSabado() {
        return sabado;
    }

    public void setSabado(ArrayList<String> sabado) {
        this.sabado = sabado;
    }

    public void setDateTime(String dia, String hora) {

        switch (dia) {

            case "L":
                if (validar(dia, hora)) {
                    lunes.add(hora);
                    Collections.sort(lunes);
                }
                break;
            case "M":
                if (validar(dia, hora)) {
                    martes.add(hora);
                    Collections.sort(martes);
                }
                break;
            case "I":
                if (validar(dia, hora)) {
                    miercoles.add(hora);
                }
                break;
            case "J":
                if (validar(dia, hora)) {
                    jueves.add(hora);
                }
                break;
            case "V":
                if (validar(dia, hora)) {
                    viernes.add(hora);
                }
                break;
            case "S":
                if (validar(dia, hora)) {
                    sabado.add(hora);
                }
                break;
        }
    }

    public boolean validar(String dia, String hora) {
        return true;
    }
}


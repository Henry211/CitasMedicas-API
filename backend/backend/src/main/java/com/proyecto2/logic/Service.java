/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.logic;

import com.proyecto2.data.AdministradorDao;
import com.proyecto2.data.CitaDao;
import com.proyecto2.data.CiudadDao;
import com.proyecto2.data.DoctorDao;
import com.proyecto2.data.EspecialidadDao;
import com.proyecto2.data.PacienteDao;
import java.util.ArrayList;
import java.util.List;

public class Service {

    PacienteDao pDao = new PacienteDao();
    DoctorDao mDao = new DoctorDao();
    AdministradorDao aDao = new AdministradorDao();
    CiudadDao cidDao = new CiudadDao();
    CitaDao citDao = new CitaDao();
    EspecialidadDao esDao = new EspecialidadDao();
    //HorarioDao horDao = new HorarioDao();

    public Service() {
    }

    // Singleton implementation
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    // Service methods
    //paciente
   

    public void createPaciente(Paciente paciente) throws Exception {
        pDao.create(paciente);
    }

    //administrador
    public Administrador administradorLogin(Administrador administrador) throws Exception {
        return aDao.read(administrador);
    }

    public void createAdministrador(Administrador admi) throws Exception {
        aDao.create(admi);
    }

    //medico
    public Doctor medicoLogin(String cedula, String clave) throws Exception {
        return mDao.read(cedula,clave);
    }

    public void editarMedico(Doctor medico) throws Exception {
        mDao.update(medico);
    }

    public void createMedico(Doctor medico) throws Exception {
        mDao.create(medico);
    }

}


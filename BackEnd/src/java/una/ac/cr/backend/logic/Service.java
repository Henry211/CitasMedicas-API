
package una.ac.cr.backend.logic;

import una.ac.cr.backend.data.AdministradorDao;
import una.ac.cr.backend.data.CitaDao;
import una.ac.cr.backend.data.CiudadDao;
import una.ac.cr.backend.data.DoctorDao;
import una.ac.cr.backend.data.EspecialidadDao;
import una.ac.cr.backend.data.PacienteDao;
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
    
    public void createCita(Cita cita) throws Exception {
        citDao.create(cita);
    }

    //administrador
    public Administrador administradorLogin(Administrador administrador) throws Exception {
        return aDao.read(administrador);
    }

    public void createAdministrador(Administrador admi) throws Exception {
        aDao.create(admi);
    }

    //medico
    public Doctor medicoLogin(Doctor medico) throws Exception {
        return mDao.read1(medico);
    }

    public void editarMedico(Doctor medico) throws Exception {
        mDao.update(medico);
    }

    public void createMedico(Doctor medico) throws Exception {
        mDao.create(medico);
    }
    
     public ArrayList<Doctor> findAllMedicos() throws Exception {
        return mDao.findAll();
    }
     
    public void eliminarDoctor(Doctor id) throws Exception {
        mDao.delete(id);
    }
    
     public ArrayList<Paciente> findAllPacientes() throws Exception {
        return pDao.findAll();
    }
     
      public ArrayList<Dia> getMedicoDias(String cedula) throws Exception {
        return mDao.findDays(cedula);
    }


}


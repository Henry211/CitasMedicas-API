
package una.ac.backend.logic;

import una.ac.backend.data.AdministradorDao;
import una.ac.backend.data.CitaDao;
import una.ac.backend.data.CiudadDao;
import una.ac.backend.data.DoctorDao;
import una.ac.backend.data.EspecialidadDao;
import una.ac.backend.data.PacienteDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

public class Service {
    
    /*@Context
    HttpServletRequest request;
       
    HttpSession session = request.getSession(true);*/

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

    public /*static*/ Doctor getDoc(Doctor user)throws Exception{
        System.out.println("Logueando doc");            
        // switch 'radio btn' ( doc-admin )
        
        Doctor result = mDao.read(user.getId(), user.getPassword());
        if (result==null) throw new Exception("Usuario no existe");
        
        return result;
    } 
    
    
    
    public /*static*/ Administrador getAdmin(Administrador user)throws Exception{
        System.out.println("Logueando admin");
       
            // switch 'radio btn' ( doc-admin )
        
        Administrador result = aDao.read(user.getNombre(), user.getClave());
        if (result==null) throw new Exception("Usuario no existe");
        
        return result;
    } 
   

    public void createPaciente(Paciente paciente) throws Exception {
        pDao.create(paciente);
    }
    
    public void createCita(Cita cita) throws Exception {
        citDao.create(cita);
    }

    //administrador
   /* public Administrador administradorLogin(Administrador administrador) throws Exception {
        return aDao.read(administrador);
    }*/

    public void createAdministrador(Administrador admi) throws Exception {
        aDao.create(admi);
    }

    //medico
    public Doctor medicoLogin(Doctor medico) throws Exception {
        return mDao.read1(medico);
    }
    
       
    public Doctor medicoString(String medico) throws Exception {
        return mDao.leerString(medico);
    }
    
        
    public void medicoDelete(String medico) throws Exception {
         mDao.delete(medico);
    }

    public void editarMedico(Doctor medico) throws Exception {
        mDao.update(medico);
    }
    
    public void updateCita(Cita cita) throws Exception {
        citDao.update(cita);
    }

    public void createMedico(Doctor medico) throws Exception {
        mDao.create(medico);
    }
    
     public ArrayList<Doctor> findAllMedicos() throws Exception {
        return mDao.findAll();
    }
     
    public void doctorDelete(String doc) throws Exception {
        mDao.delete(doc);
    }
    
     public ArrayList<Paciente> findAllPacientes() throws Exception {
        return pDao.findAll();
    }
     
      public ArrayList<Dia> getMedicoDias(String cedula) throws Exception {
        return mDao.findDays(cedula);
    }
      
    public void pacienteDelete(String pac) throws Exception {
        pDao.delete(pac);
    }
    
    public Paciente pacienteByCedula(String cedula) throws Exception {
        return pDao.read(cedula);
    }
    
    public Paciente pacienteByCitaId(String idCita) throws Exception {
        return pDao.byCitaId(idCita);
    }
    
    public void pacienteUpdate(Paciente paciente) throws Exception {
        pDao.update(paciente);
    }
    
     public ArrayList<Cita> findCitasByCedula(String cedula) throws Exception {
        return citDao.readByMedico(cedula);
    }
     
      public Cita citaById(String idCita) throws Exception {
        return citDao.readById(idCita);
    }
    
    


}


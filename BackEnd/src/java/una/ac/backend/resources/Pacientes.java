/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.resources;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import una.ac.backend.logic.Cita;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Paciente;
import una.ac.backend.logic.Service;



@Path("/pacientes")
public class Pacientes {
    
    
    @Context
    HttpServletRequest request;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Paciente pac){
        try{
            Service.instance().createPaciente(pac);
            
        }catch(Exception e){
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("/cita/{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCita(@PathParam("cedula") String cedula, Cita cita){
        try{
            
            Doctor usuario = (Doctor) request.getSession(true).getAttribute("user");
            Paciente pacSelected = read(cedula);
            //   !!!!!!!!!!!!!!
            //TODO:  ERROR aquí, al llamar atributos de usuario:
            
            cita.setMedico(usuario);
            cita.setPaciente(pacSelected);
            System.out.println("User session = "+ cita.getPaciente().getCedula());
            //   !!!!!!!!!!!!!!!!!
            System.out.println("CreateCita: "+cita);
            Service.instance().createCita(cita);
            
        }catch(Exception e){
            throw new NotAcceptableException();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> read() throws Exception{
        return Service.instance().findAllPacientes();
       
    }
    
    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente read(@PathParam("cedula") String cedula){
        try{
            System.out.println("hey");
            return Service.instance().pacienteByCedula(cedula);
           
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Paciente p){
        try{
            System.out.println("Update hey");
            //Service.instance().pacienteUpdate(p); 
            
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula){
        try{
            System.out.println("BorrarPAciente");
            Service.instance().pacienteDelete(cedula);
        } catch(Exception e){
            throw new NotFoundException();
        }
    }
    
}

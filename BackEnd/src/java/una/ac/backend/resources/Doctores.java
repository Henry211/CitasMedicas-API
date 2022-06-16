/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.resources;

import java.util.ArrayList;
import java.util.List;
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
import javax.ws.rs.core.MediaType;
import una.ac.cr.backend.logic.Dia;
import una.ac.cr.backend.logic.Doctor;
import una.ac.cr.backend.logic.Service;

/**
 *
 * @author Henry
 */

@Path("/doctores")
public class Doctores {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Doctor doc){
        try{
            System.out.println("Doctor->"+doc);
            Service.instance().createMedico(doc);
            
        }catch(Exception e){
            throw new NotAcceptableException();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> read() throws Exception{
        return Service.instance().findAllMedicos();
       
    }
    
    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor read(@PathParam("cedula") String cedula,Doctor d){
        try{
            
            return Service.instance().medicoLogin(d);
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("/dias/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Dia> readDias(@PathParam("cedula") String cedula){
        try{
            System.out.println("Entró a dias");
            return Service.instance().getMedicoDias(cedula);
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Doctor d){
        try{
            Service.instance().editarMedico(d); 
            
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula,Doctor d){
        try{
            Service.instance().eliminarDoctor(d);
        } catch(Exception e){
            throw new NotFoundException();
        }
    }
    
}

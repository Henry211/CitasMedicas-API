/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.resources;

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
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Paciente;
import una.ac.backend.logic.Service;

/**
 *
 * @author Henry
 */

@Path("/pacientes")
public class Pacientes {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Paciente pac){
        try{
            System.out.println("PAciente->"+pac);
            Service.instance().createPaciente(pac);
            
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
            //return Service.instance().doctorRead(cedula);
            return null;
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Paciente p){
        try{
            //Service.instance().doctorUpdate(d); 
            
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula){
        try{
            //Service.instance().doctorDelete(cedula);
        } catch(Exception e){
            throw new NotFoundException();
        }
    }
    
}
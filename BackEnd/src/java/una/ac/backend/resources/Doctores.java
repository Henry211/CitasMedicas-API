/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.glassfish.jersey.media.multipart.FormDataParam;
import una.ac.backend.logic.Cita;
import una.ac.backend.logic.Dia;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Horario;
import una.ac.backend.logic.Service;


@Path("/doctores")
public class Doctores {
    String location="C:/AAA/images/";
    
    @Context
    HttpServletRequest request;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Doctor doc) {
        try {
            System.out.println("Doctor->" + doc);
            Service.instance().createMedico(doc);

        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
    @GET
    @RolesAllowed({"ADM"})  //-- listar medicos para aceptar registros
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> read() throws Exception {
        return Service.instance().findAllMedicos();

    }
//----------------Imagen
    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor read(@PathParam("cedula") String cedula) {
        try {

            return Service.instance().medicoString(cedula);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("{cedula}/imagen")
    @Produces("image/png")
    public Response getImge(@PathParam("cedula") String cedula) throws IOException {
        File file = new File(location+cedula);
        ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }    
    
        
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA) 
    @Path("{cedula}/imagen")
    public void addImage(@PathParam("cedula") String cedula, @FormDataParam("imagen") InputStream in) {  
        try{
                OutputStream out = new FileOutputStream(new File(location + cedula));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException(); 
            }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ADM"})  
    public void update(Doctor p) {  
        try {
            Service.instance().editarMedico(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    //----------
    @GET
    @Path("/dias/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Dia> readDias(@PathParam("cedula") String cedula) {
        try {
            
            return Service.instance().getMedicoDias(cedula);
        } catch (Exception e) {
            throw new NotFoundException();
        
        }
    }
    
    
    @GET
    @Path("/citasExistentes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cita> citasExistentes() {
        try {
            Doctor user = (Doctor) request.getSession(true).getAttribute("user");
            String idMedico = user.getId();
            return Service.instance().findCitasByCedula(idMedico);
        } catch (Exception e) {
            throw new NotFoundException();
        
        }
    }

    @PUT
    @Path("/horario")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateHorario(@PathParam("cedula") String cedula, Horario horario) {
        try {
            // Service.instance().editarMedico(d); 

        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Doctor d) {
        try {
            Service.instance().editarMedico(d);

        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula) {
        try {
            Service.instance().doctorDelete(cedula);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

}

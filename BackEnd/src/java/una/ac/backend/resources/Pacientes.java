/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.resources;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.annotation.security.PermitAll;
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
import javax.ws.rs.core.Response;
import una.ac.backend.logic.Cita;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Paciente;
import una.ac.backend.logic.Service;



@Path("/pacientes")
public class Pacientes {
    
    String location = "C:/AAA/images/";
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
        System.out.println("read pacientes..");
        return Service.instance().findAllPacientes();
       
    }
    
    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente read(@PathParam("cedula") String cedula){
        try{
            return Service.instance().pacienteByCedula(cedula);
           
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("/byCitaId/{idCita}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente byCitaId(@PathParam("idCita") String idCita){
        try{
            System.out.println("byCitaId");
            return Service.instance().pacienteByCitaId(idCita);
           
        }catch(Exception e){
            throw new NotFoundException();
        }
    }
    
    /*@GET
    @Path("{cedula}/pdf")
    @Produces("application/pdf")
    public Response getPdf(@PathParam("cedula") String cedula) throws IOException {
        File file = new File(location + cedula);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }
    */
    @GET 
    @Path("{cedula}/pdf")
    @Produces("application/pdf")
    @PermitAll    
    public Response getPdf(@PathParam("cedula") String cedula) throws IOException {
        Paciente per=null;
        try { per = Service.instance().pacienteByCedula(cedula);} catch (Exception ex) {}
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(out));
        Document doc = new Document(pdf, PageSize.A4.rotate());
        
        Paragraph p;
        
        p = new Paragraph("DATOS DE PERSONA");
        p.setTextAlignment(TextAlignment.CENTER);
        p.setBold();
        p.setBackgroundColor(Color.PINK);
        doc.add(p);

        p = new Paragraph("CEDULA: "+per.getCedula());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);

        p = new Paragraph("NOMBRE: "+per.getNombre());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);
        
//        Image img = new Image(ImageDataFactory.create(location+per.getCedula()));
//        doc.add(img);        

        p = new Paragraph("FIN");
        p.setTextAlignment(TextAlignment.CENTER);
        p.setBold();
        p.setBackgroundColor(Color.PINK);
        doc.add(p);

        doc.close(); 
        
        return Response.ok(out.toByteArray()).build();
    }
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Paciente p){
        try{
            System.out.println("Update hey");
            Service.instance().pacienteUpdate(p); 
            
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

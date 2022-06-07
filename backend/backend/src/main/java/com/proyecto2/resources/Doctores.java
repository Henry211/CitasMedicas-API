/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.proyecto2.logic.Service;
import com.proyecto2.logic.Doctor;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;

@Path("/doctores")
public class Doctores {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Doctor p) {  
        try {
            Service.instance().personasCREATE(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> read() { 
        return Service.instance().personasREAD();
    }     
    
    @GET
    @Path("{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public Doctor read(@PathParam("cedula") String cedula) {
        try {
            return Service.instance().personasREAD(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Doctor p) {  
        try {
            Service.instance().personasUPDATE(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula) {
        try {
            Service.instance().personasDELETE(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
  
}


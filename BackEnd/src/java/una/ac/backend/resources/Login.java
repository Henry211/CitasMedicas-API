package una.ac.backend.resources;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import una.ac.backend.logic.Administrador;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Service;

/**
 *
 * @author Henry
 */
@Path("/login")
@PermitAll

public class Login {

    @Context
    HttpServletRequest request;

    
    @POST
    @Path("/doctor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor loginDoc(Doctor user) {
        Doctor logged = null;
       

        try {    
                //HttpSession session = request.getSession(true);
                logged = Service.instance().getDoc(user);             
                
                if(logged != null){
                    System.out.println("Se ha logueado "+ logged);
                    request.setAttribute("user", logged);
                }
            return logged;
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }
    
    
    @POST
    @Path("/admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Administrador loginAdmin(Administrador user) {
        Administrador logged = null;
        

        try {
            System.out.println("POST login 1");
            

            logged = Service.instance().getAdmin(user);                

            request.getSession(true).setAttribute("user", logged);
            return logged;
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @DELETE
    public void logout() {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.invalidate();
    }

}

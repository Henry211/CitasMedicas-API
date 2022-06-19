
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
import una.ac.backend.logic.Service;
import una.ac.backend.logic.Usuario;

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Usuario login(Usuario usuario) {  
            Usuario logged=null;
                        
            try {
                System.out.println("POST login 1");
                logged= Service.instance().get(usuario);
                System.out.println("POST login 2");
                if(!logged.getPassword().equals(usuario.getPassword())) throw new Exception("Clave incorrecta");
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

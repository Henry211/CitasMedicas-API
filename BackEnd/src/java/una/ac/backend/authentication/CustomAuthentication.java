/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.authentication;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Usuario;

/**
 *
 * @author Henry
 */
/*
@ApplicationScoped
public class CustomAuthentication 
  implements HttpAuthenticationMechanism {

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request,HttpServletResponse response,HttpMessageContext httpMsgContext) 
       {
           Doctor user=(Doctor) request.getSession().getAttribute("user"); //-- SESSION
           if(user!=null)
              return httpMsgContext.notifyContainerAboutLogin(
                new Principal() { @Override public String getName() { return user.getNombre();}},
                new HashSet<>(Arrays.asList(new String[]{"CLI"})));
           else
              return httpMsgContext.notifyContainerAboutLogin(
                new Principal() { @Override public String getName() { return "none";}},
                new HashSet<>());               
    }
}
*/
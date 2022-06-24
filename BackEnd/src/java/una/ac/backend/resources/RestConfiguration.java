
package una.ac.backend.resources;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author Henry
 */
@ApplicationPath("api")
@DeclareRoles({ "ADM", "CLI" })
public class RestConfiguration extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(MultiPartFeature.class);
        classes.add(Doctores.class);
        classes.add(Pacientes.class);
        classes.add(Login.class);  
        return classes;
    }  
    
}
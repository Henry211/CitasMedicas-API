/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import una.ac.backend.logic.Ciudad;
import una.ac.backend.logic.Especialidad;
import una.ac.backend.logic.Medico;

/**
 *
 * @author ESCINF
 */
public class DoctorDao {
    Database db;

    public DoctorDao() {
        db = Database.instance();
    }
    
        public void create(Medico u) throws Exception {

        String sql = "insert into medico (nombre,idMedicos,clave,estado,tarifa,nombre_provincia,nombre_especialidad) "
                + "values(?,?,?,?,?,?,?)";

        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getNombre());
        stm.setString(2, u.getCedula());
        stm.setString(3, u.getClave());
        stm.setString(4, u.getEstado());
        stm.setInt(5, u.getTarifa());
        stm.setObject(6, u.getCiudad());
        stm.setObject(7, u.getEspecialidad());
        //byte[] image = new byte[]{0} ;
        //InputStream targetStream = new ByteArrayInputStream(image);
        //stm.setBlob(7, targetStream);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico ya existe");
        }
    }
        
         public Medico read(Medico u) throws Exception {
        String sql = "select * from medico c where idMedicos=? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getClave());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Medico c = from(rs, "c");
            return c;
        } else {
            throw new Exception("medico existente");
        }
    }
         
           Medico from(ResultSet rs, String alias) {
        try {
            Medico c = new Medico();
            c.setCedula(rs.getString(alias + ".idMedicos"));
            c.setNombre(rs.getString(alias + ".nombre"));
            c.setClave(rs.getString(alias + ".clave"));
            c.setEstado(rs.getString(alias + ".estado"));
            c.setTarifa(rs.getInt(alias + ".tarifa"));
            String str = rs.getString(alias + ".nombre_provincia");
            Ciudad ciuu = new Ciudad(str);
            c.setCiudad(ciuu);
            String str2 = rs.getString(alias + ".nombre_especialidad");
            Especialidad espe = new Especialidad(str2);
            c.setEspecialidad(espe);
            //Blob blob = rs.getBlob(alias + ".image");
            /*
            if(blob != null){
                int blobLength = (int) blob.length();  
                byte[] blobAsBytes = blob.getBytes(1, blobLength);
                c.setImage(blobAsBytes);
                blob.free();
            }
*/
            return c;
        }
    catch ( SQLException ex) {
            //ex.printStackTrace();
            return null;
        }
    }
        
        
    
}

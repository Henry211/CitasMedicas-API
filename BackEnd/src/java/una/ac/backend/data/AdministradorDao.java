/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import una.ac.backend.logic.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class AdministradorDao {
    Database db;
    
    public AdministradorDao(){
        db= Database.instance();
    }

     public void create(Administrador u) throws Exception{
        String sql="insert into administrador (tipo, nombre, id,clave) "+
                "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getTipo());
        stm.setString(2, u.getId());
        stm.setString(3, u.getNombre());
        stm.setString(4, u.getClave());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador ya existe");
        }
    }
    
    public Administrador read(String cedula,String clave) throws Exception{
        String sql = "select * from administrador c where id=? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        stm.setString(2, clave);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Administrador c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Administrador existente");
        }
    }
    
    public void update(Administrador u) throws Exception{
        String sql="update administrador set nombre=?, clave=? "+
                "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getId());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());       
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador no existe");
        }        
    }

    public void delete(Administrador c) throws Exception{
        String sql="delete from administrador where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getId());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
    }
        
    public String cambiarClave(String cedula, String cambioClave) throws Exception{
        String sql="UPDATE administrador SET clave=? WHERE id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioClave);
        stm.setString(2, cedula);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
        return "Clave actualizada exitosamente";
    }
        
        
    Administrador from(ResultSet rs, String alias){
        try {
            Administrador c= new Administrador();
            c.setTipo(rs.getString(alias + ".tipo"));
            c.setId(rs.getString(alias+".id"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setClave(rs.getString(alias+".clave"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }  
        
}


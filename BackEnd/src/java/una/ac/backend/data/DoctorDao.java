/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import una.ac.backend.logic.Ciudad;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Especialidad;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import una.ac.backend.logic.Dia;

/**
 *
 * @author ESCINF
 */
public class DoctorDao {
     Database db;

    public DoctorDao() {
        db = Database.instance();
    }
     
    //registrar medico
    public void create(Doctor u) throws Exception {

        String sql = "insert into medico(tipo,nombre,idMedicos,clave,tarifa,nombre_provincia,nombre_especialidad) "
                + "values(?,?,?,?,?,?,?)";

        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getTipo());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getId());
        stm.setString(4, u.getPassword());
        stm.setString(5, u.getTarifa());
        stm.setString(6, u.getLocalidad());
        stm.setString(7, u.getEspecialidad());
        System.out.println("docName-> "+ u.getEspecialidad());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico ya existe");
        }
    }
    
    // el Login
    public Doctor read1(Doctor u) throws Exception {
        String sql = "select * from medico c where idMedicos=? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getId());
        stm.setString(2, u.getPassword());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Doctor c = from(rs, "c");
            return c;
        } else {
            throw new Exception("Medico existente");
        }
    
    } 
    public Doctor read(String cedula, String clave) throws Exception{
        String sql = "select * from medico c where idMedicos=? and clave=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        stm.setString(2, clave);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Doctor c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Medico no existe");
        }
    }
    
    public ArrayList<Dia> findDays(String cedula) throws Exception{
        String sql = "select * from medico c where idMedicos=? and clave=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
       
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Doctor c = from(rs, "c"); 
            return null;
        }
        else{
            throw new Exception ("Medico no existe");
        }
    }
    
    //busca por id
     public Doctor find(String u) throws Exception{
        String sql = "select * from medico c where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Doctor c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Medico no existe");
        }
    }
     
     //editar datos de un medico
     public void update(Doctor u) throws Exception {
        String sql = "update medico set tarifa=?,nombre_provincia=?,nombre_especialidad=?"
                + "where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getTarifa());
        //stm.setObject(2, u.getLocalidad().getProvincia());
        //stm.setObject(3, u.getEspecialidad().getEspecialidad());
        //para imagen por base de datos
        //InputStream targetStream = new ByteArrayInputStream(u.getImage());
       // stm.setBlob(4, targetStream);
        stm.setString(4, u.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
     }
     
     //BORRA UN MEDICO
    public void delete(Doctor c) throws Exception {
        String sql = "delete from medico where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }

    //cambiar password
    public String cambiarClave(String cedula, String cambioClave) throws Exception {
        String sql = "UPDATE medico SET clave=? WHERE idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioClave);
        stm.setString(2, cedula);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
        return "Clave actualizada exitosamente";
    }
    
     public ArrayList<Doctor> findAll() {
        ArrayList<Doctor> resultado = new ArrayList<>();
        try {
            String sql = "select * from medico ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Doctor c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
     
         
     Doctor from(ResultSet rs, String alias) {
        try {
            Doctor c = new Doctor();
            c.setTipo(rs.getString(alias + ".tipo"));
            c.setId(rs.getString(alias + ".idMedicos"));
            c.setNombre(rs.getString(alias + ".nombre"));
            c.setPassword(rs.getString(alias + ".clave"));
            c.setTarifa(rs.getString(alias + ".tarifa"));
            c.setEspecialidad(rs.getString(alias + ".nombre_especialidad"));
            c.setLocalidad(rs.getString( alias + ".nombre_provincia"));
            return c;
        }
    catch ( SQLException ex) {
            return null;
        }
    }
    
    
}

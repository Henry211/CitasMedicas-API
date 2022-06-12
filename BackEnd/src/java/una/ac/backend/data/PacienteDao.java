/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import una.ac.backend.logic.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ESCINF
 */
public class PacienteDao {
       Database db;

    public PacienteDao() {
        db= Database.instance();
    }
      
    //inserta pacientes
     public void create(Paciente u) throws Exception{
        String sql="insert into paciente (nombre,cedula,enfermedades,alergias,cirugias,contacto_emergencia) "+
                "values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
     
        stm.setString(1, u.getNombre());
        stm.setString(2, u.getCedula());
        stm.setString(3, u.getEnfermedad());
        stm.setString(4, u.getAlergias());
        stm.setString(5, u.getCirugia());
        stm.setString(6, u.getContacEmergencia());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Paciente ya existe");
        }
    }
     //trae pacientes 
     public Paciente select(Paciente u) throws Exception{
        String sql = "select * from paciente";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Paciente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Paciente existente");
        }
    }
     //trae pacientes por cedula
     public Paciente read(String u) throws Exception{
        String sql = "select * from paciente c where c.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Paciente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Paciente no existe");
        }
    }
     
     //Lista TODOS LOS PACIENTES
      public ArrayList<Paciente> findAll() {
        ArrayList<Paciente> resultado = new ArrayList<>();
        try {
            String sql = "select * from paciente c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Paciente c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
        Paciente from(ResultSet rs, String alias){
        try {
            Paciente c= new Paciente();
            c.setCedula(rs.getString(alias+".cedula"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setEnfermedad(rs.getString(alias+".enfermedades"));
            c.setAlergias(rs.getString(alias+".alergias"));
            c.setCirugia(rs.getString(alias+".cirugias"));
            c.setContacEmergencia(rs.getString(alias+".contacto_emergencia"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
       
    
}


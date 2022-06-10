/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.data;
import com.proyecto2.logic.Cita;
import com.proyecto2.logic.Doctor;
import com.proyecto2.logic.Paciente;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ESCINF
 */
public class CitaDao {
    Database db;

    public CitaDao() {
        db = Database.instance();
    }

     
    //registrar medico
    public void create(Cita u) throws Exception {

        String sql = "insert into cita(idCita,estado,dateStr,horaStr,paciente,medico) "
                + "values(?,?,?,?,?,?)";

        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdCita());
        stm.setString(2, u.getEstado());
        stm.setString(3, u.getDateStr());
        stm.setString(4, u.getHoraStr());
        stm.setObject(5, u.getPaciente());
        stm.setObject(6, u.getMedico());
        byte[] image = new byte[]{0} ;
        InputStream targetStream = new ByteArrayInputStream(image);
        stm.setBlob(7, targetStream);

        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita ya existe");
        }
    }
    
    // el Login
    public Cita read(Cita u) throws Exception {
        String sql = "select * from cita c where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdCita());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Cita c = from(rs, "c");
            return c;
        } else {
            throw new Exception("Cita existente");
        }
    }
    
    //busca por id
     public Cita find(int u) throws Exception{
        String sql = "select * from Cita c where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cita c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Cita no existe");
        }
    }
/*
     //editar datos de un medico
     public void update(Cita u) throws Exception {
        String sql = "update cita set tarifa=?,nombre_provincia=?,nombre_especialidad=?"
                + "where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getTarifa());
        stm.setObject(2, u.getLocalidad().getProvincia());
        stm.setObject(3, u.getEspecialidad().getEspecialidad());
        //para imagen por base de datos
        //InputStream targetStream = new ByteArrayInputStream(u.getImage());
       // stm.setBlob(4, targetStream);
        stm.setString(4, u.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
     }
     */
     
     //BORRA UN MEDICO
    public void delete(Cita c) throws Exception {
        String sql = "delete from cita where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getIdCita());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }

    
     public ArrayList<Cita> findAll() {
        ArrayList<Cita> resultado = new ArrayList<>();
        try {
            String sql = "select * from cita ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Cita c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
     
                 /*
        int idCita;
    String estado;
    LocalDateTime fecha;
    String dateStr;
    String horaStr;
    Paciente paciente;
    Doctor medico;*/
     Cita from(ResultSet rs, String alias) {
        try {
            Cita c = new Cita();
            c.setIdCita(rs.getInt(alias + ".idCita"));
            c.setEstado(rs.getString(alias + ".estado"));
            c.setDateStr(rs.getString(alias + ".dateStr"));
            c.setHoraStr(rs.getString(alias + ".horaStr"));
            String str = rs.getString(alias + ".paciente");
            Paciente pacie = new Paciente(str);
            c.setPaciente(pacie);
            String str2 = rs.getString(alias + ".medico");
            Doctor espe = new Doctor(str2);
            c.setMedico(espe);
            /*
            Blob blob = rs.getBlob(alias + ".image");
            if(blob != null){
                int blobLength = (int) blob.length();  
                byte[] blobAsBytes = blob.getBytes(1, blobLength);
                c.setImage(blobAsBytes);
                blob.free();
            }*/
            return c;
        }
    catch ( SQLException ex) {
            //ex.printStackTrace();
            return null;
        }
    }
}

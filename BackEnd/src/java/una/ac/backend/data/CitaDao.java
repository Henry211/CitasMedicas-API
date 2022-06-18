/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;
import una.ac.backend.logic.Cita;
import una.ac.backend.logic.Doctor;
import una.ac.backend.logic.Paciente;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitaDao {
    Database db;

    public CitaDao() {
        db = Database.instance();
    }

     
    //registrar medico
    //el id no se coloca es auto_increment
    public void create(Cita u) throws Exception {

        String sql = "insert into cita(estado,dia,hora,signo,diagnostico,medicina,Paciente_cedula,Medico_idMedico) "
                + "values(?,?,?,?,?,?,?,?)";

        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setString(2, u.getDateStr());
        stm.setString(3, u.getHoraStr());
        stm.setString(4, u.getSigno());
        stm.setString(5, u.getDiagnostico());
        stm.setString(6, u.getMedicina());
        stm.setObject(7, u.getPaciente());
        stm.setObject(8, u.getMedico());
        //byte[] image = new byte[]{0} ;
        //nputStream targetStream = new ByteArrayInputStream(image);
        //stm.setBlob(7, targetStream);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita ya existe");
        }
    }
    
    //Lista citas de un paciente en especifico muestra los doctores que atendieron la cita
     public ArrayList<Cita> readByPaciente(String cedula) throws Exception {
        ArrayList<Cita> resultado = new ArrayList<>();
        String sql = "select * from cita c inner join medico m on c.Medico_idMedico= m.idMedicos "
                    + " where c.Paciente_cedula=? order by m.nombre desc";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setObject(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        Cita c;
     
        while (rs.next()) {
                c = from2(rs, "c");
                resultado.add(c);
            }
        return resultado;
    }
    
    // selec por id 
    public Cita read(Cita u) throws Exception {
        String sql = "select * from cita c where idCitas=?";
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
    
         
    public void update(Cita u) throws Exception {
        String sql = "update cita set estado=?, dia=?, hora=?, signo=?, diagnostico=?, medicina=?,"
                + "where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setString(2, u.getDateStr());
        stm.setString(3, u.getHoraStr());
        stm.setString(4, u.getSigno());
        stm.setString(5, u.getDiagnostico());
        stm.setString(6, u.getMedicina());  
        //para imagen por base de datos
        //InputStream targetStream = new ByteArrayInputStream(u.getImage());
       // stm.setBlob(4, targetStream);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
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
        String sql = "delete from cita where idCitas=?";
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
     
     
    Cita from(ResultSet rs, String alias) {
        try {
            Cita c = new Cita();
            c.setIdCita(rs.getInt(alias + ".idCitas"));
            c.setEstado(rs.getString(alias + ".estado"));
            c.setDateStr(rs.getString(alias + ".dateStr"));
            c.setHoraStr(rs.getString(alias + ".horaStr"));
            String str = rs.getString(alias + ".paciente");
            Paciente pacie = new Paciente(str);
            c.setPaciente(pacie);
            String str2 = rs.getString(alias + ".medico");
           // Doctor espe = new Doctor(str2);
            //c.setMedico(espe);
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
     
      Cita from2(ResultSet rs, String alias) {
        try {
            Cita c = new Cita();
            c.setIdCita(rs.getInt(alias + ".idCitas"));
            c.setEstado(rs.getString(alias + ".estado"));
            c.setDateStr(rs.getString(alias + ".dia"));
            c.setHoraStr(rs.getString(alias + ".hora"));
            //-----------
            Paciente p = new Paciente();
            p.setCedula(rs.getString(alias + ".Paciente_cedula"));
            c.setPaciente(p);
            Doctor m = new Doctor();
            m.setId(rs.getString(alias + ".Medico_idMedico"));
            m.setNombre(rs.getString("m.nombre"));
            m.setLocalidad(rs.getString("m.nombre_provincia"));
            m.setEspecialidad(rs.getString("m.nombre_especialidad"));
            c.setMedico(m);
            //------------
//            c.getPaciente().setCedula(rs.getString(alias + ".Paciente_cedula"));
//            c.getMedico().setCedula(rs.getString(alias + ".Medico_idMedico"));
            return c;
        } catch (SQLException ex) {
            return null;
        } 
    }
}

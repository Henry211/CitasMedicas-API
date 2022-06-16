/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import una.ac.backend.logic.Ciudad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ESCINF
 */
public class CiudadDao {
    
    Database db;

    public CiudadDao() {
        db = Database.instance();
    }

    public void create(Ciudad u) throws Exception {
        String sql = "insert into localidad (provincia) "
                + "values(?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getProvincia());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Localidad ya existe");
        }
    }

    public Ciudad read(Ciudad u) throws Exception {
        String sql = "select * from localidad c where provincia=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getProvincia());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Ciudad c = from(rs, "c");
            return c;
        } else {
            throw new Exception("Ciudad existente");
        }

    }
    
     public ArrayList<Ciudad> findAll() {
        ArrayList<Ciudad> resultado = new ArrayList<>();
        try {
            String sql = "select * from localidad c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Ciudad c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

     
      Ciudad from(ResultSet rs, String alias) {
        try {
            Ciudad c = new Ciudad();
            c.setProvincia(rs.getString(alias + ".provincia"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}

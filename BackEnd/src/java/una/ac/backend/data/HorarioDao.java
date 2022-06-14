/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import una.ac.backend.logic.Horario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author alfon
 */
public class HorarioDao {
    Database db;

    public HorarioDao() {
        db = Database.instance();
    }

    public void create(Horario u) throws Exception {
        String sql = "insert into slot (idDoctor,checked, desde, hasta)" 
                + "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getIdDoctor());
        stm.setBoolean(2, u.isChecked());
        stm.setString(3, u.getDesde());
        stm.setString(4, u.getHasta());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario ya existe");
        }
    }

    public Horario read(Horario u) throws Exception {
        String sql = "select * from slot c where idDoctor=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getIdDoctor());
        ResultSet rs = (ResultSet) db.executeQuery(stm);
        if (rs.next()) {
            Horario c = from(rs, "c");
            return c;
        } else {
            throw new Exception("Horario existente");
        }
    }

    public void update(Horario u) throws Exception {
        String sql = "update slot set checked=?, desde=?, hasta=?" + "where idDoctor=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setBoolean(1, u.isChecked());
        stm.setString(2, u.getDesde());
        stm.setString(3, u.getHasta());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario no existe");
        }
    }
    
        public ArrayList<Horario> findAll() {
        ArrayList<Horario> resultado = new ArrayList<>();
        try {
            String sql = "select * from slot c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = (ResultSet) db.executeQuery(stm);
            Horario c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    Horario from(ResultSet rs, String alias) {
        try {
            Horario c = new Horario();
            c.setIdDoctor(rs.getString(alias + ".idDoctor"));
            c.setId(rs.getInt(alias + ".id"));
            c.setChecked(rs.getBoolean(alias+ ".checked"));
            c.setDesde(rs.getString(alias + ".desde"));
            c.setHasta(rs.getString(alias + ".hasta"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
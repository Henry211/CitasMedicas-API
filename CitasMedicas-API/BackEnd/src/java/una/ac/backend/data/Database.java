/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.backend.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class Database {
    

    private final String database_driver="com.mysql.cj.jdbc.Driver";
    private final String database_server="localhost";
    private final String database_port="3306";
    private final String database_user="MariaF";
    private final String database_password="root";
    private final String database_name="usuarios2";
    
    private static Database theInstance;
    public static Database instance(){
        if (theInstance==null){ 
            theInstance=new Database();
        }
        return theInstance;
    }
    public static final String PROPERTIES_FILE_NAME="/resources/database.properties";        
    Connection cnx;
    public Database(){
        cnx=this.getConnection();            
    }
    public final Connection getConnection(){
        try {     
            String URL_conexion="jdbc:mysql://"+ database_server+":"+database_port+"/"+
                    database_name+"?user="+database_user+"&password="+database_password + "&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";            
            Class.forName(database_driver).newInstance();
            return DriverManager.getConnection(URL_conexion);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.exit(-1);
        } 
        return null;
    }
    
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }
    public int executeUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public ResultSet executeQuery(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }    
}

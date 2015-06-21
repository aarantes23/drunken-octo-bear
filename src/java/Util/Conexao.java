package Util;

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Arthur
 */
public class Conexao {
    
    private static Connection connection;
    public Statement stmt;
    private String driver;
    private String local;
    private String user;
    private String password;

    public Conexao() {
       driver = "com.mysql.jdbc.Driver";
       local = "jdbc:mysql://localhost/hotel";
       user = "root";
       password = "root";
    }
                
    public void getConnection(){
        stmt = null;
        try {  
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            
        }
        try {
            connection = (Connection) DriverManager.getConnection(local,user,password);
            stmt = (Statement) connection.createStatement();

        } catch (SQLException ex) {
            
        }
    }    
    
    public void desconnect(){
        try {
            stmt.close();
        } catch (SQLException ex) {

        }
        try {
            connection.close();
        } catch (SQLException ex) {

        }
    }

}    
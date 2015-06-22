package DbHelper;

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur
 */
public class DbHelper {
    
    private static Connection connection;
    public Statement stmt;
    private final String driver;
    private final String local;
    private final String user;
    private final String password;

    public DbHelper() {
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
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = (Connection) DriverManager.getConnection(local,user,password);
            stmt = (Statement) connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void desconnect(){
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}    
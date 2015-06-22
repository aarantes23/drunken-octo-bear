/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.CheckIn;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class CheckInDao {

    DbHelper dbHelper = new DbHelper();

    public CheckInDao() {
    }
        
    /**
     * Insert a new CheckIn in the database
     *
     * @param checkIn
     * @return true for ok , false for erro
     */
    public boolean insert(CheckIn checkIn) {
        dbHelper.getConnection();
        String query = "INSERT INTO Check_in VALUES ("
                + "" + checkIn.getId() + ","
                + "'" + checkIn.getDate() + "',"
                + "" + checkIn.getStatus() + ""
                + ");";
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Get all CheckIn in the database
     *
     * @return
     */
    public ArrayList<CheckIn> search() {
        ArrayList<CheckIn> arrayList = new ArrayList<CheckIn>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Check_in";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                CheckIn checkIn = new CheckIn();
                checkIn.setId(resultSet.getInt(1));
                checkIn.setDate(resultSet.getString(2));
                checkIn.setStatus(resultSet.getInt(3));
                arrayList.add(checkIn);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }

        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single CheckIn in the database
     *
     * @param checkIn
     * @return true for ok , false for erro
     */
    public boolean update(CheckIn checkIn) {
        dbHelper.getConnection();
        String query = "UPDATE Check_in SET "
                + " date = '" + checkIn.getDate() + "',"
                + " status = '" + checkIn.getStatus()   
                + " WHERE id = " + checkIn.getId();
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return true;

        } catch (SQLException e) {
            dbHelper.desconnect();
            return false;
        }
    }

    /**
     * Delete a single CheckIn in the database
     *
     * @param checkIn
     * @return true for ok , false for erro
     */
    public boolean delete(CheckIn checkIn) {
        dbHelper.getConnection();
        String query = "DELETE FROM Check_in "
                + " WHERE id = " + checkIn.getId();
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return true;

        } catch (SQLException e) {
            dbHelper.desconnect();
            return false;
        }
    }
}


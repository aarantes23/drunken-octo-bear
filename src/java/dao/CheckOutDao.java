/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.CheckOut;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class CheckOutDao {

    DbHelper dbHelper = new DbHelper();

    public CheckOutDao() {
    }

    /**
     * Insert a new CheckOut in the database
     *
     * @param checkOut
     * @return true for ok , false for erro
     */
    public boolean insert(CheckOut checkOut) {
        dbHelper.getConnection();
        String query = "INSERT INTO Check_out VALUES ("
                + "" + checkOut.getId() + ","
                + "'" + checkOut.getDate() + "',"
                + "" + checkOut.getStatus()
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
     * Get all CheckOut in the database
     *
     * @return
     */
    public ArrayList<CheckOut> search() {
        ArrayList<CheckOut> arrayList = new ArrayList<CheckOut>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Check_out";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                CheckOut checkOut = new CheckOut();
                checkOut.setId(resultSet.getInt(1));
                checkOut.setDate(resultSet.getString(2));
                checkOut.setStatus(resultSet.getInt(3));
                arrayList.add(checkOut);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }

        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single CheckOut in the database
     *
     * @param checkOut
     * @return true for ok , false for erro
     */
    public boolean update(CheckOut checkOut) {
        dbHelper.getConnection();
        String query = "UPDATE Check_out SET "
                + " date = '" + checkOut.getDate() + "',"
                + " status = " + checkOut.getStatus()
                + " WHERE id = " + checkOut.getId();
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
     * Delete a single CheckOut in the database
     *
     * @param checkOut
     * @return true for ok , false for erro
     */
    public boolean delete(CheckOut checkOut) {
        dbHelper.getConnection();
        String query = "DELETE FROM Check_out "
                + " WHERE id = " + checkOut.getId();
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

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.CheckOut;
import DbHelper.DbHelper;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class CheckOutDao {

    Strings strings = new Strings();
    DbHelper dbHelper = new DbHelper();

    public CheckOutDao() {
    }

    /**
     * Insert a new CheckOut in the database
     *
     * @param checkOut
     * @return
     */
    public String insert(CheckOut checkOut) {
        dbHelper.getConnection();
        String query = "INSERT INTO Check_out VALUES ("
                + "" + checkOut.getId() + ","
                + "'" + checkOut.getData() + "'"
                + ");";
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return (strings.insert_ok);
        } catch (SQLException ex) {
            return (strings.insert_erro);
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
                checkOut.setData(resultSet.getString(2));
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
     * @return
     */
    public String update(CheckOut checkOut) {
        dbHelper.getConnection();
        String query = "UPDATE Check_out SET "
                + " data = '" + checkOut.getData() + "'"
                + " WHERE id = " + checkOut.getId();
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return (strings.editar_ok);

        } catch (SQLException e) {
            dbHelper.desconnect();
            return (strings.editar_erro);
        }
    }

    /**
     * Delete a single CheckOut in the database
     *
     * @param checkOut
     * @return
     */
    public String delete(CheckOut checkOut) {
        dbHelper.getConnection();
        String query = "DELETE FROM Check_out "
                + " WHERE id = " + checkOut.getId();
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return (strings.delete_ok);

        } catch (SQLException e) {
            dbHelper.desconnect();
            return (strings.delete_erro);
        }
    }
}

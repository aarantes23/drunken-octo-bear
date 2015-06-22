/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.CheckOut_has_Item;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class CheckOut_has_Item_Dao {

    DbHelper dbHelper = new DbHelper();

    public CheckOut_has_Item_Dao() {
    }

    /**
     * Insert a new CheckOut_has_Item in the database
     *
     * @param checkOut_has_Item
     * @return true for ok , false for erro
     */
    public boolean insert(CheckOut_has_Item checkOut_has_Item) {
        dbHelper.getConnection();
        String query = "INSERT INTO CheckOut_has_Item VALUES ("
                + "" + checkOut_has_Item.getCheck_out_id() + ","
                + "" + checkOut_has_Item.getItem_id() + ""
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
     * Get all CheckOut_has_Items in the database
     *
     * @return
     */
    public ArrayList<CheckOut_has_Item> search() {
        ArrayList<CheckOut_has_Item> arrayList = new ArrayList<CheckOut_has_Item>();
        dbHelper.getConnection();
        String query = "SELECT * FROM CheckOut_has_Item";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                CheckOut_has_Item checkOut_has_Item = new CheckOut_has_Item();
                checkOut_has_Item.setCheck_out_id(resultSet.getInt(1));
                checkOut_has_Item.setItem_id(resultSet.getInt(2));
                arrayList.add(checkOut_has_Item);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }
    
}

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Item;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ItemDao {

    DbHelper dbHelper = new DbHelper();

    public ItemDao() {
    }

    /**
     * Insert a new Item in the database
     *
     * @param item
     * @return true for ok , false for erro
     */
    public boolean insert(Item item) {
        dbHelper.getConnection();
        String query = "INSERT INTO Item VALUES ("
                + "" + item.getId() + ","
                + "'" + item.getName()+ "',"
                + "" + item.getPrice()
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
     * Get all Consumptions in the database
     *
     * @return
     */
    public ArrayList<Item> search() {
        dbHelper.getConnection();
        ArrayList<Item> arrayList = new ArrayList<Item>();
        String query = "SELECT * FROM Item";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setPrice(resultSet.getFloat(3));                
                arrayList.add(item);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single Item in the database
     *
     * @param item
     * @return true for ok , false for erro
     */
    public boolean update(Item item) {
        dbHelper.getConnection();
        String query = "UPDATE Item SET "                
                + " name = '" + item.getName() + "',"
                + " price = " + item.getPrice()
                + " WHERE id = " + item.getId();
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
     * Delete a single Item in the database
     *
     * @param item
     * @return true for ok , false for erro
     */
    public boolean delete(Item item) {
        dbHelper.getConnection();
        String query = "DELETE FROM item "
                + " WHERE id = " + item.getId();
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

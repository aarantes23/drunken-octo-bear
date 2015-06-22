/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Item;
import DbHelper.DbHelper;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ItemDao {

    Strings strings = new Strings();
    DbHelper dbHelper = new DbHelper();

    public ItemDao() {
    }

    /**
     * Insert a new Item in the database
     *
     * @param item
     * @return
     */
    public String insert(Item item) {
        dbHelper.getConnection();
        String query = "INSERT INTO Item VALUES ("
                + "" + item.getId() + ","
                + "" + item.getValor() + ","
                + "" + item.getNome()
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
                item.setValor(resultSet.getFloat(2));
                item.setNome(resultSet.getString(3));
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
     * @return
     */
    public String update(Item item) {
        dbHelper.getConnection();
        String query = "UPDATE Item SET "
                + " valor = " + item.getValor() + ","
                + " nome = '" + item.getNome() + "'"
                + " WHERE id = " + item.getId();
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
     * Delete a single Item in the database
     *
     * @param item
     * @return
     */
    public String delete(Item item) {
        dbHelper.getConnection();
        String query = "DELETE FROM item "
                + " WHERE id = " + item.getId();
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

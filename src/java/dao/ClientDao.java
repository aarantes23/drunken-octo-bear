/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Client;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ClientDao {

    DbHelper dbHelper = new DbHelper();

    public ClientDao() {
    }

    /**
     * Insert a new Client in the database
     *
     * @param cliente
     * @return true for ok , false for erro
     */
    public boolean insert(Client cliente) {
        dbHelper.getConnection();
        String query = "INSERT INTO Client VALUES ("
                + "" + cliente.getId() + ","
                + "'" + cliente.getName() + "',"
                + "'" + cliente.getAddress() + "',"
                + "'" + cliente.getCpf() + "',"
                + "'" + cliente.getRg() + "',"
                + "'" + cliente.getPhone() + "',"
                + "'" + cliente.getSex() + "'"
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
     * Get all Clientes in the database
     *
     * @return 
     */
    public ArrayList<Client> search() {
        ArrayList<Client> arrayList = new ArrayList<Client>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Client";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Client cliente = new Client();
                cliente.setId(resultSet.getInt(1));
                cliente.setName(resultSet.getString(2));
                cliente.setAddress(resultSet.getString(3));
                cliente.setCpf(resultSet.getString(4));
                cliente.setRg(resultSet.getString(5));
                cliente.setPhone(resultSet.getString(6));
                cliente.setSex(resultSet.getString(7));
                arrayList.add(cliente);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single Client in the database
     *
     * @param cliente
     * @return true for ok , false for erro
     */
    public boolean update(Client cliente) {
        dbHelper.getConnection();
        String query = "UPDATE Client SET "
                + " name = '" + cliente.getName() + "',"
                + " address = '" + cliente.getAddress() + "',"
                + " cpf = '" + cliente.getCpf() + "',"
                + " rg = '" + cliente.getRg() + "',"
                + " phone = '" + cliente.getPhone() + "',"
                + " sex = '" + cliente.getSex() + "'"
                + " WHERE id = " + cliente.getId();
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
     * Delete a single Client in the database
     *
     * @param cliente
     * @return true for ok , false for erro
     */
    public boolean delete(Client cliente) {
        dbHelper.getConnection();
        String query = "DELETE FROM Client "
                + " WHERE id = " + cliente.getId();
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

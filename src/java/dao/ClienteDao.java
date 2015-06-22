/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Cliente;
import DbHelper.DbHelper;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ClienteDao {

    Strings strings = new Strings();
    DbHelper dbHelper = new DbHelper();

    public ClienteDao() {
    }

    /**
     * Insert a new Cliente in the database
     *
     * @param cliente
     * @return
     */
    public String insert(Cliente cliente) {
        dbHelper.getConnection();
        String query = "INSERT INTO Cliente VALUES ("
                + "" + cliente.getId() + ","
                + "'" + cliente.getNome() + "',"
                + "'" + cliente.getEndereco() + "',"
                + "'" + cliente.getCpf() + "',"
                + "'" + cliente.getRg() + "',"
                + "'" + cliente.getTelefone() + "',"
                + "'" + cliente.getSexo() + "'"
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
     * Get all Clientes in the database
     *
     * @return
     */
    public ArrayList<Cliente> search() {
        ArrayList<Cliente> arrayList = new ArrayList<Cliente>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Cliente";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setEndereco(resultSet.getString(3));
                cliente.setCpf(resultSet.getString(4));
                cliente.setRg(resultSet.getString(5));
                cliente.setTelefone(resultSet.getString(6));
                cliente.setSexo(resultSet.getString(7));
                arrayList.add(cliente);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single Cliente in the database
     *
     * @param cliente
     * @return
     */
    public String update(Cliente cliente) {
        dbHelper.getConnection();
        String query = "UPDATE Cliente SET "
                + " nome = '" + cliente.getNome() + "',"
                + " endereco = '" + cliente.getEndereco() + "',"
                + " cpf = '" + cliente.getCpf() + "',"
                + " rg = '" + cliente.getRg() + "',"
                + " telefone = '" + cliente.getTelefone() + "',"
                + " sexo = '" + cliente.getSexo() + "'"
                + " WHERE id = " + cliente.getId();
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
     * Delete a single Cliente in the database
     *
     * @param cliente
     * @return
     */
    public String delete(Cliente cliente) {
        dbHelper.getConnection();
        String query = "DELETE FROM Cliente "
                + " WHERE id = " + cliente.getId();
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

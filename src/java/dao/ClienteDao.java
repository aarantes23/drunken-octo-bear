/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Bean.Cliente;
import Util.Conexao;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ClienteDao {

    Conexao conexao = new Conexao();
    Strings strings = new Strings();

    public ClienteDao() {
    }

    /**
     * Insert a new Cliente in the database
     *
     * @param cliente
     * @return
     */
    public String insert(Cliente cliente) {
        conexao.getConnection();
        String query = "INSERT INTO cliente VALUES ("
                + "" + cliente.getCodigo() + ","
                + "'" + cliente.getNome() + "',"
                + "'" + cliente.getEndereco() + "',"
                + "'" + cliente.getBairro() + "',"
                + "'" + cliente.getCep() + "',"
                + "'" + cliente.getNumero() + "',"
                + "'" + cliente.getCidade() + "',"
                + "'" + cliente.getTelefone() + "',"
                + "'" + cliente.getEmail() + "'"
                + ");";
        try {
            conexao.stmt.execute(query);
            conexao.desconnect();
            return (strings.insert_ok);
        } catch (SQLException ex) {
            return (strings.insert_erro);
        }
    }

    /**
     * Get all Clientes in the database
     *
     * @return a arraylist with all clients
     */
    public ArrayList<Cliente> search() {
        ArrayList<Cliente> arrayList = new ArrayList<Cliente>();
        conexao.getConnection();
        String query = "SELECT * FROM cliente";
        ResultSet resultSet;
        try {
            resultSet = conexao.stmt.executeQuery(query);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultSet.getInt(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setEndereco(resultSet.getString(3));
                cliente.setBairro(resultSet.getString(4));
                cliente.setCep(resultSet.getString(5));
                cliente.setNumero(resultSet.getString(6));
                cliente.setCidade(resultSet.getString(7));
                cliente.setTelefone(resultSet.getString(8));
                cliente.setEmail(resultSet.getString(9));
                arrayList.add(cliente);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        conexao.desconnect();
        return arrayList;
    }

    /**
     * Update a single Cliente in the database
     *
     * @param cliente
     * @return a String with the result
     */
    public String update(Cliente cliente) {
        conexao.getConnection();
        String query = "UPDATE cliente SET "
                + " nome = '" + cliente.getNome() + "',"
                + " endereco = '" + cliente.getEndereco() + "',"
                + " bairro = '" + cliente.getBairro() + "',"
                + " cep = '" + cliente.getCep() + "',"
                + " numero = '" + cliente.getNumero() + "',"
                + " cidade = '" + cliente.getCidade() + "',"
                + " telefone = '" + cliente.getTelefone() + "',"
                + " email = '" + cliente.getEmail() + "'"
                + " WHERE codigo = " + cliente.getCodigo();
        try {
            conexao.stmt.execute(query);
            conexao.desconnect();
            return (strings.editar_ok);
        } catch (SQLException e) {
            conexao.desconnect();
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
        conexao.getConnection();
        String query = "DELETE FROM cliente "
                + " WHERE codigo = " + cliente.getCodigo();
        try {
            conexao.stmt.execute(query);
            conexao.desconnect();
            return (strings.delete_ok);
        } catch (SQLException e) {
            conexao.desconnect();
            return (strings.delete_erro);
        }
    }
  
}

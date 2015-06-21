/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Bean.Quarto;
import Util.Conexao;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class QuartoDao {

    Conexao conexao = new Conexao();
    Strings strings = new Strings();

    public QuartoDao() {
    }

    /**
     * Insert a new Quarto in the database
     *
     * @param quarto
     * @return
     */
    public String insert(Quarto quarto) {
        conexao.getConnection();
        String query = "INSERT INTO quarto VALUES ("
                + "" + quarto.getCodigo() + ","
                + "'" + quarto.getAndar() + "',"
                + "'" + quarto.getTipo() + "',"
                + "'" + quarto.getQuantAcom() + "'"
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
     * Get all Quartos in the database
     *
     * @return a arraylist with all clients
     */
    public ArrayList<Quarto> search() {
        ArrayList<Quarto> arrayList = new ArrayList<Quarto>();
        conexao.getConnection();
        String query = "SELECT * FROM quarto";
        ResultSet resultSet;
        try {
            resultSet = conexao.stmt.executeQuery(query);
            while (resultSet.next()) {
                Quarto quarto = new Quarto();
                quarto.setCodigo(resultSet.getInt(1));
                quarto.setAndar(resultSet.getString(2));
                quarto.setTipo(resultSet.getString(3));
                quarto.setQuantAcom(resultSet.getString(4));
                arrayList.add(quarto);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        conexao.desconnect();
        return arrayList;
    }

    /**
     * Update a single Quarto in the database
     *
     * @param quarto
     * @return a String with the result
     */
    public String update(Quarto quarto) {
        conexao.getConnection();
        String query = "UPDATE quarto SET "
                + " andar = '" + quarto.getAndar() + "',"
                + " tipo = '" + quarto.getTipo() + "',"
                + " quantAcom = '" + quarto.getQuantAcom() + "'"
                + " WHERE codigo = " + quarto.getCodigo();
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
     * Delete a single Quarto in the database
     *
     * @param quarto
     * @return
     */
    public String delete(Quarto quarto) {
        conexao.getConnection();
        String query = "DELETE FROM quarto "
                + " WHERE codigo = " + quarto.getCodigo();
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

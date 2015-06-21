/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Bean.Reserva;
import Util.Conexao;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ReservaDao {

    Conexao conexao = new Conexao();
    Strings strings = new Strings();

    public ReservaDao() {
    }

    /**
     * Insert a new Reserva in the database
     *
     * @param reserva
     * @return
     */
    public String insert(Reserva reserva) {
        conexao.getConnection();
        String query = "INSERT INTO reserva VALUES ("
                + "" + reserva.getCodigo() + ","
                + "" + reserva.getCodCliente() + ","
                + "" + reserva.getCodQuarto() + ","
                + "'" + reserva.getDataCheckin() + "',"
                + "'" + reserva.getDataCheckout() + "',"
                + "" + reserva.getQtdePessoa() + ""
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
     * Get all Reserva in the database
     *
     * @return a arraylist with all reserva
     */
    public ArrayList<Reserva> search() {
        ArrayList<Reserva> arrayList = new ArrayList<Reserva>();
        conexao.getConnection();
        String query = "SELECT * FROM reserva";
        ResultSet resultSet;
        try {
            resultSet = conexao.stmt.executeQuery(query);
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setCodigo(resultSet.getInt(1));
                reserva.setCodCliente(resultSet.getInt(2));
                reserva.setCodQuarto(resultSet.getInt(3));
                reserva.setDataCheckin(resultSet.getString(4));
                reserva.setDataCheckout(resultSet.getString(5));
                arrayList.add(reserva);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        conexao.desconnect();
        return arrayList;
    }

    /**
     * Update a single Reserva in the database
     *
     * @param reserva
     * @return a String with the result
     */
    public String update(Reserva reserva) {
        conexao.getConnection();
        String query = "UPDATE reserva SET "
                + " codCliente = " + reserva.getCodCliente() + ","
                + " codQuarto = " + reserva.getCodQuarto() + ","
                + " dataCheckin = '" + reserva.getDataCheckin() + "',"
                + " dataCheckout = '" + reserva.getDataCheckout() + "',"
                + " qtdePessoa = " + reserva.getQtdePessoa()
                + " WHERE codigo = " + reserva.getCodigo();
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
     * Delete a single Reserva in the database
     *
     * @param reserva
     * @return
     */
    public String delete(Reserva reserva) {
        conexao.getConnection();
        String query = "DELETE FROM reserva "
                + " WHERE codigo = " + reserva.getCodigo();
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

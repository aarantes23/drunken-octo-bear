/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Reserva;
import DbHelper.DbHelper;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ReservaDao {

    Strings strings = new Strings();
    DbHelper dbHelper = new DbHelper();

    public ReservaDao() {
    }
    
    /**
     * Insert a new Reserva in the database
     *
     * @param reserva
     * @return
     */
    public String insert(Reserva reserva) {
        dbHelper.getConnection();
        String query = "INSERT INTO Reserva VALUES ("
                + "" + reserva.getId() + ","
                + "'" + reserva.getData_check_in() + "',"
                + "" + reserva.getCliente_id()+ ","
                + "" + reserva.getUsuario_id() + ","
                + "" + reserva.getCheck_out_id() + ","
                + "" + reserva.getQuarto_id()
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
     * Get all Reservas in the database
     *
     * @return
     */
    public ArrayList<Reserva> search() {
        ArrayList<Reserva> arrayList = new ArrayList<Reserva>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Reserva";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(resultSet.getInt(1));
                reserva.setData_check_in(resultSet.getInt(2));
                reserva.setQuarto_id(resultSet.getInt(3));
                reserva.setUsuario_id(resultSet.getInt(4));
                reserva.setCheck_out_id(resultSet.getInt(5));
                reserva.setQuarto_id(resultSet.getInt(6));
                arrayList.add(reserva);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single Reserva in the database
     *
     * @param reserva
     * @return
     */
    public String update(Reserva reserva) {
        dbHelper.getConnection();
        String query = "UPDATE Reserva SET "
                + " data_check_in = '" + reserva.getData_check_in() + "',"
                + " Cliente_id = " + reserva.getCliente_id() + ","
                + " Usuario_id = " + reserva.getUsuario_id() + ","
                + " Check_out  = " + reserva.getCheck_out_id() + ","
                + " Quarto_id = " + reserva.getQuarto_id()
                + " WHERE id = " + reserva.getId();
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
     * Delete a single Reserva in the database
     *
     * @param reserva
     * @return
     */
    public String delete(Reserva reserva) {
        dbHelper.getConnection();
        String query = "DELETE FROM Reserva "
                + " WHERE id = " + reserva.getId();
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

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Reservation;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ReservationDao {

    DbHelper dbHelper = new DbHelper();

    public ReservationDao() {
    }

    /**
     * Insert a new Reservation in the database
     *
     * @param reservation
     * @return true for ok , false for erro
     */
    public boolean insert(Reservation reservation) {
        dbHelper.getConnection();
        String query = "INSERT INTO reservation VALUES ("
                + "" + reservation.getId() + ","
                + "" + reservation.getRoom_id() + ","
                + "" + reservation.getClient_id() + ","
                + "" + reservation.getUser_id() + ","
                + "" + reservation.getCheck_out_id() + ","
                + "" + reservation.getCheck_in_id()
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
     * Get all Reservas in the database
     *
     * @return
     */
    public ArrayList<Reservation> search() {
        ArrayList<Reservation> arrayList = new ArrayList<Reservation>();
        dbHelper.getConnection();
        String query = "SELECT * FROM reservation";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Reservation reserva = new Reservation();
                reserva.setId(resultSet.getInt(1));
                reserva.setRoom_id(resultSet.getInt(2));
                reserva.setClient_id(resultSet.getInt(3));
                reserva.setUser_id(resultSet.getInt(4));
                reserva.setCheck_out_id(resultSet.getInt(5));
                reserva.setCheck_in_id(resultSet.getInt(6));
                arrayList.add(reserva);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single Reservation in the database
     *
     * @param reservation
     * @return true for ok , false for erro
     */
    public boolean update(Reservation reservation) {
        dbHelper.getConnection();
        String query = "UPDATE reservation SET "
                + " Room_id = " + reservation.getRoom_id() + ","
                + " Client_id = " + reservation.getClient_id() + ","
                + " User_id = " + reservation.getUser_id() + ","
                + " Check_out_id  = " + reservation.getCheck_out_id() + ","
                + " Check_in_id  = " + reservation.getCheck_in_id()
                + " WHERE id = " + reservation.getId();
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
     * Delete a single Reservation in the database
     *
     * @param reservation
     * @return true for ok , false for erro
     */
    public boolean delete(Reservation reservation) {
        dbHelper.getConnection();
        String query = "DELETE FROM reservation "
                + " WHERE id = " + reservation.getId();
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

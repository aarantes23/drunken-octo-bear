/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Room;
import DbHelper.DbHelper;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class RoomDao {

    Strings strings = new Strings();
    DbHelper dbHelper = new DbHelper();

    public RoomDao() {
    }

    /**
     * Insert a new Room in the database
     *
     * @param room
     * @return
     */
    public String insert(Room room) {
        dbHelper.getConnection();
        String query = "INSERT INTO Quarto VALUES ("
                + "" + room.getId() + ","
                + "" + room.getNumero() + ","
                + "'" + room.getAndar() + "',"
                + "'" + room.getTipo() + "',"
                + "" + room.getValorDiaria()
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
     * Get all Rooms in the database
     *
     * @return
     */
    public ArrayList<Room> search() {
        ArrayList<Room> arrayList = new ArrayList<Room>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Quarto";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt(1));
                room.setNumero(resultSet.getInt(2));
                room.setAndar(resultSet.getString(3));
                room.setTipo(resultSet.getString(4));
                room.setValorDiaria(resultSet.getInt(5));
                arrayList.add(room);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single Room in the database
     *
     * @param room
     * @return
     */
    public String update(Room room) {
        dbHelper.getConnection();
        String query = "UPDATE Quarto SET "
                + " numero = " + room.getNumero() + ","
                + " andar = '" + room.getAndar() + "',"
                + " tipo = '" + room.getTipo() + "',"
                + " valorDiaria = " + room.getValorDiaria()
                + " WHERE id = " + room.getId();
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
     * Delete a single Room in the database
     *
     * @param room
     * @return
     */
    public String delete(Room room) {
        dbHelper.getConnection();
                String query = "DELETE FROM Quarto  "
                + " WHERE id = " + room.getId();
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

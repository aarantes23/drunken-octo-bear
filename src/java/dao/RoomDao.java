/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.Room;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class RoomDao {

    DbHelper dbHelper = new DbHelper();

    public RoomDao() {
    }

    /**
     * Insert a new Room in the database
     *
     * @param room
     * @return true for ok , false for erro
     */
    public boolean insert(Room room) {
        dbHelper.getConnection();
        String query = "INSERT INTO room VALUES ("
                + "" + room.getId() + ","
                + "" + room.getNumber() + ","
                + "'" + room.getFloor() + "',"
                + "'" + room.getType() + "',"
                + "" + room.getDaily_value()
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
     * Get all Rooms in the database
     *
     * @return 
     */
    public ArrayList<Room> search() {
        ArrayList<Room> arrayList = new ArrayList<Room>();
        dbHelper.getConnection();
        String query = "SELECT * FROM room";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt(1));
                room.setNumber(resultSet.getInt(2));
                room.setFloor(resultSet.getString(3));
                room.setType(resultSet.getString(4));
                room.setDaily_value(resultSet.getInt(5));
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
     * @return true for ok , false for erro
     */
    public boolean update(Room room) {
        dbHelper.getConnection();
        String query = "UPDATE room SET "
                + " number = " + room.getNumber() + ","
                + " floot = '" + room.getFloor() + "',"
                + " type = '" + room.getType() + "',"
                + " dailyValue = " + room.getDaily_value()
                + " WHERE id = " + room.getId();
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
     * Delete a single Room in the database
     *
     * @param room
     * @return true for ok , false for erro
     */
    public boolean delete(Room room) {
        dbHelper.getConnection();
                String query = "DELETE FROM room  "
                + " WHERE id = " + room.getId();
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

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.User;
import DbHelper.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class UserDao {

    DbHelper dbHelper = new DbHelper();

    public UserDao() {
    }

    /**
     * Insert a new User in the database
     *
     * @param user
     * @return true for ok , false for erro
     */
    public boolean insert(User user) {
        dbHelper.getConnection();
        String query = "INSERT INTO user VALUES ("
                + "" + user.getId() + ","
                + "'" + user.getName() + "',"
                + "'" + user.getLogin() + "',"
                + "'" + user.getPassword() + "',"
                + "'" + user.getCpf() + "',"
                + "'" + user.getPhone() + "',"
                + "'" + user.getAddress() + "',"
                + "'" + user.getRg() + "',"
                + "'" + user.getSex() + "',"
                + "'" + user.getBirthday() + "',"
                + "" + user.getUserType()
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
     * Get all Users in the database
     *
     * @return
     */
    public ArrayList<User> search() {
        ArrayList<User> arrayList = new ArrayList<User>();
        dbHelper.getConnection();
        String query = "SELECT * FROM user";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setCpf(resultSet.getString(5));
                user.setPhone(resultSet.getString(6));
                user.setAddress(resultSet.getString(7));
                user.setRg(resultSet.getString(8));
                user.setSex(resultSet.getString(9));
                user.setBirthday(resultSet.getString(10));
                user.setUserType(resultSet.getInt(11));
                arrayList.add(user);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        dbHelper.desconnect();
        return arrayList;
    }

    /**
     * Update a single User in the database
     *
     * @param user
     * @return true for ok , false for erro
     */
    public boolean update(User user) {
        dbHelper.getConnection();
        String query = "UPDATE user SET "
                + " name = '" + user.getName() + "',"
                + " login = '" + user.getLogin() + "',"
                + " password = '" + user.getPassword() + "',"
                + " cpf = '" + user.getCpf() + "',"
                + " phone = '" + user.getPhone() + "',"
                + " address = '" + user.getAddress() + "',"
                + " rg = '" + user.getRg() + "',"
                + " sex = '" + user.getSex() + "',"
                + " birthday = '" + user.getBirthday() + "',"
                + " userType = " + user.getUserType()
                + " WHERE id = " + user.getId();
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
     * Delete a single User in the database
     *
     * @param user
     * @return true for ok , false for erro
     */
    public boolean delete(User user) {
        dbHelper.getConnection();
        String query = "DELETE FROM user"
                + " WHERE id = " + user.getId();
        try {
            dbHelper.stmt.execute(query);
            dbHelper.desconnect();
            return true;
        } catch (SQLException e) {
            dbHelper.desconnect();
            return true;
        }
    }

}

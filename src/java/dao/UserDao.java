/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Beans.User;
import DbHelper.DbHelper;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class UserDao {

    Strings strings = new Strings();
    DbHelper dbHelper = new DbHelper();

    public UserDao() {
    }

    /**
     * Insert a new User in the database
     *
     * @param user
     * @return
     */
    public String insert(User user) {
        dbHelper.getConnection();
        String query = "INSERT INTO Usuario VALUES ("
                + "" + user.getId() + ","
                + "'" + user.getNome() + "',"
                + "'" + user.getLogin() + "',"
                + "'" + user.getSenha() + "',"
                + "'" + user.getCpf() + "',"
                + "'" + user.getTelefone() + "',"
                + "'" + user.getEndereco() + "',"
                + "'" + user.getRg() + "',"
                + "'" + user.getSexo() + "',"
                + "'" + user.getData_nascimento() + "',"
                + "" + user.getUserType()
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
     * Get all Users in the database
     *
     * @return
     */
    public ArrayList<User> search() {
        ArrayList<User> arrayList = new ArrayList<User>();
        dbHelper.getConnection();
        String query = "SELECT * FROM Usuario";
        ResultSet resultSet;
        try {
            resultSet = dbHelper.stmt.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setNome(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setSenha(resultSet.getString(4));
                user.setCpf(resultSet.getString(5));
                user.setTelefone(resultSet.getString(6));
                user.setEndereco(resultSet.getString(7));
                user.setRg(resultSet.getString(8));
                user.setSexo(resultSet.getString(9));
                user.setData_nascimento(resultSet.getString(10));
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
     * @return
     */
    public String update(User user) {
        dbHelper.getConnection();
        String query = "UPDATE Usuario SET "
                + " nome = '" + user.getNome() + "',"
                + " login = '" + user.getLogin() + "',"
                + " senha = '" + user.getSenha() + "',"
                + " cpf = '" + user.getCpf() + "',"
                + " telefone = '" + user.getTelefone() + "',"
                + " endereco = '" + user.getEndereco() + "',"
                + " rg = '" + user.getRg() + "',"
                + " sexo = '" + user.getSexo() + "',"
                + " data_nascimento = '" + user.getData_nascimento() + "',"
                + " tipo = " + user.getUserType()
                + " WHERE id = " + user.getId();
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
     * Delete a single User in the database
     *
     * @param user
     * @return
     */
    public String delete(User user) {
        dbHelper.getConnection();
        String query = "DELETE FROM Usuario"
                + " WHERE id = " + user.getId();
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

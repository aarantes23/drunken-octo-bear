/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Bean.Usuario;
import Util.Conexao;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class UsuarioDao {

    Conexao conexao = new Conexao();
    Strings strings = new Strings();

    public UsuarioDao() {
    }

    /**
     * Insert a new Usuario in the database
     *
     * @param usuario
     * @return
     */
    public String insert(Usuario usuario) {
        conexao.getConnection();
        String query = "INSERT INTO usuario VALUES ("
                + "" + usuario.getCodigo() + ","
                + "'" + usuario.getNome() + "',"
                + "'" + usuario.getEmail() + "',"
                + "'" + usuario.getSenha() + "',"
                + "" + usuario.getTipo()
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
     * Get all Usuario in the database
     *
     * @return a arraylist with all usuarios
     */
    public ArrayList<Usuario> search() {
        ArrayList<Usuario> arrayList = new ArrayList<Usuario>();
        conexao.getConnection();
        String query = "SELECT * FROM usuario";
        ResultSet resultSet;
        try {
            resultSet = conexao.stmt.executeQuery(query);
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultSet.getInt(1));
                usuario.setNome(resultSet.getString(2));
                usuario.setEmail(resultSet.getString(3));
                usuario.setSenha(resultSet.getString(4));
                usuario.setTipo(resultSet.getInt(5));
                arrayList.add(usuario);
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
     * @param usuario
     * @return a String with the result
     */
    public String update(Usuario usuario) {
        conexao.getConnection();
        String query = "UPDATE usuario SET "
                + " nome = '" + usuario.getNome() + "',"
                + " email = '" + usuario.getEmail() + "',"
                + " senha = '" + usuario.getSenha() + "',"
                + " tipo = " + usuario.getTipo()
                + " WHERE codigo = " + usuario.getCodigo();
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
     * Delete a single Usuario in the database
     *
     * @param usuario
     * @return
     */
    public String delete(Usuario usuario) {
        conexao.getConnection();
        String query = "DELETE FROM usuario "
                + " WHERE codigo = " + usuario.getCodigo();
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

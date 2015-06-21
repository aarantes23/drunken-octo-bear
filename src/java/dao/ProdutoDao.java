/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Bean.Produto;
import Util.Conexao;
import Values.Strings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ProdutoDao {

    Conexao conexao = new Conexao();
    Strings strings = new Strings();

    public ProdutoDao() {
    }

    /**
     * Insert a new Produto in the database
     *
     * @param produto
     * @return
     */
    public String insert(Produto produto) {
        conexao.getConnection();
        String query = "INSERT INTO produto VALUES ("
                + "" + produto.getCodigo() + ","
                + "'" + produto.getDescricao() + "',"
                + "'" + produto.getValor() + "'"
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
     * Get all Produto in the database
     *
     * @return a arraylist with all clients
     */
    public ArrayList<Produto> search() {
        ArrayList<Produto> arrayList = new ArrayList<Produto>();
        conexao.getConnection();
        String query = "SELECT * FROM produto";
        ResultSet resultSet;
        try {
            resultSet = conexao.stmt.executeQuery(query);
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setCodigo(resultSet.getInt(1));
                produto.setDescricao(resultSet.getString(2));
                produto.setValor(resultSet.getFloat(3));
                arrayList.add(produto);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        conexao.desconnect();
        return arrayList;
    }

    /**
     * Update a single Produto in the database
     *
     * @param produto
     * @return a String with the result
     */
    public String update(Produto produto) {
        conexao.getConnection();
        String query = "UPDATE produto SET "
                + " descricao = '" + produto.getDescricao() + "',"
                + " valor = " + produto.getValor()
                + " WHERE codigo = " + produto.getCodigo();
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
     * Delete a single Produto in the database
     *
     * @param produto
     * @return
     */
    public String delete(Produto produto) {
        conexao.getConnection();
        String query = "DELETE FROM produto "
                + " WHERE codigo = " + produto.getCodigo();
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

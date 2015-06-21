/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import Bean.Consumo;
import Util.Conexao;
import Values.Strings;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Arthur 
 */
public class ConsumoDao {

    Conexao conexao = new Conexao();
    Strings strings = new Strings();

    public ConsumoDao(){
    }

    /**
     * Insert a new Consumption in the database
     *
     * @param consumo
     * @return
     */
    public String insert(Consumo consumo) {
        conexao.getConnection();
        String query = "INSERT INTO consumo VALUES ("
                + "" + consumo.getCodigo() + ","
                + "'" + consumo.getCodProd() + ","
                + "'" + consumo.getCodClinte() + ","
                + "'" + consumo.getQuantidade() + ","
                + "'" + consumo.getValorTotal()
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
     * Get all Consumptions in the database
     *
     * @return
     */
    public ArrayList<Consumo> search() {
        conexao.getConnection();
        ArrayList<Consumo> arrayList = new ArrayList<Consumo>();
        String query = "SELECT * FROM consumo";
        ResultSet resultSet;
        try {
            resultSet = conexao.stmt.executeQuery(query);
            while (resultSet.next()) {
                Consumo consumo = new Consumo();
                consumo.setCodigo(resultSet.getInt(1));
                consumo.setCodProd(resultSet.getInt(2));
                consumo.setCodClinte(resultSet.getInt(3));
                consumo.setQuantidade(resultSet.getInt(4));
                consumo.setValorTotal(resultSet.getFloat(5));
                arrayList.add(consumo);
            }
            resultSet.close();
        } catch (SQLException ex) {
        }
        conexao.desconnect();
        return arrayList;
    }

    /**
     * Update a single Consumption in the database
     *
     * @param consumo
     * @return
     */
    public String update(Consumo consumo) {
        conexao.getConnection();
        String query = "UPDATE consumo SET "
                + " codProduto = '" + consumo.getCodProd() + ","
                + " codCliente = '" + consumo.getCodClinte() + ","
                + " quantidade = '" + consumo.getQuantidade() + ","
                + " valorTotal = '" + consumo.getValorTotal()
                + " WHERE codigo = " + consumo.getCodigo();
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
     * Delete a single Consumption in the database
     *
     * @param consumo
     * @return
     */
    public String delete(Consumo consumo) {
        conexao.getConnection();
        String query = "DELETE FROM consumo "
                + " WHERE codigo = " + consumo.getCodigo();
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

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.Cliente;
import dao.ClienteDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class SearchCliente extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Objects used 
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Cliente> arrayList = new ArrayList<Cliente>();

        // Recover the object cod
        cliente.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = clienteDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (cliente.getId() == arrayList.get(i).getId()) {
                cliente.setId(arrayList.get(i).getId());
                cliente.setNome(arrayList.get(i).getNome());
                cliente.setEndereco(arrayList.get(i).getEndereco());
                cliente.setCpf(arrayList.get(i).getCpf());
                cliente.setRg(arrayList.get(i).getRg());
                cliente.setTelefone(arrayList.get(i).getTelefone());
                cliente.setSexo(arrayList.get(i).getSexo());
            }
        }

        // Display de result in the java console
        System.out.println(cliente.toString());

    }

}

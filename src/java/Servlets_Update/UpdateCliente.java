/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Beans.Cliente;
import dao.ClienteDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class UpdateCliente extends HttpServlet {

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

        // Fill the object with the data obtained
        cliente.setId(Integer.parseInt(request.getParameter("codigo")));
        cliente.setNome(request.getParameter("nome"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setRg(request.getParameter("rg"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setSexo(request.getParameter("sexo"));

        // Update in the database   
        clienteDao.update(cliente);

        // Display de result in the java console
        System.out.println(cliente.toString());
    }

}

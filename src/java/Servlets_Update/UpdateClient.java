/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Beans.Client;
import dao.ClientDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class UpdateClient extends HttpServlet {

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
        Client client = new Client();
        ClientDao clientDao = new ClientDao();

        // Fill the object with the data obtained
        client.setId(Integer.parseInt(request.getParameter("codigo")));
        client.setName(request.getParameter("nome"));
        client.setAddress(request.getParameter("endereco"));
        client.setCpf(request.getParameter("cpf"));
        client.setRg(request.getParameter("rg"));
        client.setPhone(request.getParameter("telefone"));
        client.setSex(request.getParameter("sexo"));

        // Update in the database   
        clientDao.update(client);

        // Display de result in the java console
        System.out.println(client.toString());
    }

}

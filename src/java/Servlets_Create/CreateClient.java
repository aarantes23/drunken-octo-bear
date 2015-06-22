/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

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
public class CreateClient extends HttpServlet {

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
        boolean result = false;
        
        // Fill the object with the data obtained
        client.setName(request.getParameter("name"));
        client.setAddress(request.getParameter("address"));
        client.setCpf(request.getParameter("cpf"));
        client.setRg(request.getParameter("rg"));
        client.setPhone(request.getParameter("phone"));
        client.setSex(request.getParameter("sex"));

        // Insert in the database   
        result = clientDao.insert(client);
        
        // Display de result
        if (result == true){
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
                
    }
}

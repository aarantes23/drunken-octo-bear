/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.Client;
import dao.ClientDao;
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
public class SearchClient extends HttpServlet {

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
        ArrayList<Client> arrayList = new ArrayList<Client>();
        boolean result = false;

        // Recover the object cod
        client.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = clientDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (client.getId() == arrayList.get(i).getId()) {
                client.setId(arrayList.get(i).getId());
                client.setName(arrayList.get(i).getName());
                client.setAddress(arrayList.get(i).getAddress());
                client.setCpf(arrayList.get(i).getCpf());
                client.setRg(arrayList.get(i).getRg());
                client.setPhone(arrayList.get(i).getPhone());
                client.setSex(arrayList.get(i).getSex());
                result = true;
            }
        }

        // Display de result
        if (result == true) {
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }

    }

}

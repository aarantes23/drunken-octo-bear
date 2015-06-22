/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

import Beans.Item;
import dao.ItemDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class CreateItem extends HttpServlet {

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
        Item item = new Item();
        ItemDao itemDao = new ItemDao();

        // Fill the object with the data obtained
        item.setValor(Float.parseFloat(request.getParameter("valor")));
        item.setNome(request.getParameter("nome"));
        
        // Insert in the database  
        String result = itemDao.insert(item);
        
        // Display de result in the java console
        System.out.println(result);
    }
}

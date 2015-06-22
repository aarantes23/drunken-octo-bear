/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

import Beans.CheckOut_has_Item;
import dao.CheckOut_has_Item_Dao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class CreateCheckOut_has_Item extends HttpServlet {

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
        CheckOut_has_Item checkOut_has_Item = new CheckOut_has_Item();
        CheckOut_has_Item_Dao checkOut_has_Item_Dao = new CheckOut_has_Item_Dao();
        boolean result = false;
        
        // Fill the object with the data obtained
        checkOut_has_Item.setCheck_out_id(Integer.parseInt(request.getParameter("check_out")));
        checkOut_has_Item.setItem_id(Integer.parseInt(request.getParameter("item")));

        // Insert in the database   
        result = checkOut_has_Item_Dao.insert(checkOut_has_Item);
        
        // Display de result
        if (result == true){
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }

    }
}

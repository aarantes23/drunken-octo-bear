/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Beans.CheckOut;
import dao.CheckOutDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class UpdateCheckOut extends HttpServlet {

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
        CheckOut checkOut = new CheckOut();
        CheckOutDao checkOutDao = new CheckOutDao();

        // Fill the object with the data obtained
        checkOut.setId(Integer.parseInt(request.getParameter("code")));
        checkOut.setDate(request.getParameter("data_check_out"));
        checkOut.setStatus(Integer.parseInt(request.getParameter("status")));

        // Update in the database   
        checkOutDao.update(checkOut);

        // Display de result in the java console
        System.out.println(checkOut.toString());
    }

}

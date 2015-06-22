/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Delete;

import Beans.CheckIn;
import dao.CheckInDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class DeleteCheckIn extends HttpServlet {

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
        CheckIn checkIn = new CheckIn();
        CheckInDao checkInDao = new CheckInDao();
        boolean result = false;
        
        // Recover user cod 
        checkIn.setId(Integer.parseInt(request.getParameter("code")));

        // Delete in the database
        result = checkInDao.delete(checkIn);

        // Display de result
        if (result == true ){
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
    }
}

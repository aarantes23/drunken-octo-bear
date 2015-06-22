/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

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
public class CreateCheckIn extends HttpServlet {

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

        // Fill the object with the data obtained
        checkIn.setId(Integer.parseInt(request.getParameter("code")));
        checkIn.setDate(request.getParameter("date_check_in"));
        checkIn.setStatus(Integer.parseInt(request.getParameter("status")));

        // Insert in the database        
        result = checkInDao.insert(checkIn);

        // Display de result
        if (result == true) {
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
    }
}
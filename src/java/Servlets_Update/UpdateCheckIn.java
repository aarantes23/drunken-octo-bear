/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

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
public class UpdateCheckIn extends HttpServlet {

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

        // Fill the object with the data obtained
        checkIn.setId(Integer.parseInt(request.getParameter("code")));
        checkIn.setDate(request.getParameter("data_check_in"));
        checkIn.setStatus(Integer.parseInt(request.getParameter("status")));

        // Update in the database   
        checkInDao.update(checkIn);
        
        // Display de result in the java console
        System.out.println(checkIn.toString());
    }

}

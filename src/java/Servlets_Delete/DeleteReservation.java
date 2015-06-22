/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Delete;

import Beans.Reservation;
import dao.ReservationDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class DeleteReservation extends HttpServlet {

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
        Reservation reservation = new Reservation();
        ReservationDao reservationDao = new ReservationDao();
        boolean result = false;
        
        // Recover user cod         
        reservation.setId(Integer.parseInt(request.getParameter("code")));;

        // Delete in the database
        result = reservationDao.delete(reservation);

        // Display de result
        if (result == true) {
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
    }

}

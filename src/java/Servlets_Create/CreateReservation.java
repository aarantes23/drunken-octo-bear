/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

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
public class CreateReservation extends HttpServlet {

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
        Reservation reserva = new Reservation();
        ReservationDao reservaDao = new ReservationDao();
        boolean result = false;
        
        // Fill the object with the data obtained
        reserva.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
        reserva.setClient_id(Integer.parseInt(request.getParameter("client_id")));
        reserva.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        reserva.setCheck_out_id(Integer.parseInt(request.getParameter("check_out_id")));
        reserva.setCheck_in_id(Integer.parseInt(request.getParameter("check_in_id")));
        
        // Insert in the database  
        result = reservaDao.insert(reserva);

        // Display de result
        if (result == true){
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
    }
}

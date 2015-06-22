/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

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
public class UpdateReservation extends HttpServlet {

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

        // Fill the object with the data obtained        
        reservation.setId(Integer.parseInt(request.getParameter("codigo")));
        reservation.setRoom_id(Integer.parseInt(request.getParameter("quarto_id")));
        reservation.setClient_id(Integer.parseInt(request.getParameter("cliente_id")));
        reservation.setUser_id(Integer.parseInt(request.getParameter("usuario_id")));
        reservation.setCheck_out_id(Integer.parseInt(request.getParameter("check_out_id")));
        reservation.setCheck_in_id(Integer.parseInt(request.getParameter("check_in_id")));

        // Update in the database     
        reservationDao.update(reservation);

        // Display de result in the java console
        System.out.println(reservation.toString());
    }

}

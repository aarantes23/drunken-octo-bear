/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.Reservation;
import dao.ReservationDao;
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
public class SearchReservation extends HttpServlet {

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
        ArrayList<Reservation> arrayList = new ArrayList<Reservation>();
        boolean result = false;
        
        // Recover the object cod 
        reservation.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = reservationDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (reservation.getId() == arrayList.get(i).getId()) {
                reservation.setId(arrayList.get(i).getId());
                reservation.setRoom_id(arrayList.get(i).getRoom_id());
                reservation.setClient_id(arrayList.get(i).getClient_id());
                reservation.setUser_id(arrayList.get(i).getUser_id());
                reservation.setCheck_out_id(arrayList.get(i).getCheck_out_id());
                reservation.setCheck_in_id(arrayList.get(i).getCheck_in_id());
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

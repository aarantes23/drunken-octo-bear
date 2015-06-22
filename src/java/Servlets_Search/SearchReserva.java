/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.Reserva;
import dao.ReservaDao;
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
public class SearchReserva extends HttpServlet {

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
        Reserva reserva = new Reserva();
        ReservaDao reservaDao = new ReservaDao();
        ArrayList<Reserva> arrayList = new ArrayList<Reserva>();

        // Recover the object cod 
        reserva.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = reservaDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (reserva.getId() == arrayList.get(i).getId()) {
                reserva.setId(arrayList.get(i).getId());
                reserva.setData_check_in(arrayList.get(i).getData_check_in());
                reserva.setQuarto_id(arrayList.get(i).getQuarto_id());
                reserva.setCliente_id(arrayList.get(i).getCliente_id());
                reserva.setUsuario_id(arrayList.get(i).getUsuario_id());
                reserva.setCheck_out_id(arrayList.get(i).getCheck_out_id());
            }
        }

        // Display de result in the java console
        System.out.println(reserva.toString());

    }

}

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Beans.Reserva;
import dao.ReservaDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class UpdateReserva extends HttpServlet {

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

        // Fill the object with the data obtained        
        reserva.setId(Integer.parseInt(request.getParameter("codigo")));
        reserva.setData_check_in(Integer.parseInt(request.getParameter("data_check_in")));
        reserva.setQuarto_id(Integer.parseInt(request.getParameter("quarto_id")));
        reserva.setCliente_id(Integer.parseInt(request.getParameter("cliente_id")));
        reserva.setUsuario_id(Integer.parseInt(request.getParameter("usuario_id")));
        reserva.setCheck_out_id(Integer.parseInt(request.getParameter("check_out_id")));

        // Update in the database     
        reservaDao.update(reserva);

        // Display de result in the java console
        System.out.println(reserva.toString());
    }

}

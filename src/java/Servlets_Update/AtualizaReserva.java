/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Bean.Reserva;
import dao.ReservaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class AtualizaReserva extends HttpServlet {

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
        PrintWriter printWriter = response.getWriter();

        // Fill the object with the data obtained
        reserva.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        reserva.setCodCliente(Integer.parseInt(request.getParameter("codCli")));
        reserva.setCodQuarto(Integer.parseInt(request.getParameter("codQuarto")));
        reserva.setDataCheckin(request.getParameter("checkin"));
        reserva.setDataCheckout(request.getParameter("checkout"));
        reserva.setQtdePessoa(Integer.parseInt(request.getParameter("qtdePessoa")));

        // Print the response
        printWriter.println(reservaDao.update(reserva));
    }

}

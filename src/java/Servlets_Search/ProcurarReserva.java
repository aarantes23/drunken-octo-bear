/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Bean.Reserva;
import dao.ReservaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class ProcurarReserva extends HttpServlet {

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
        PrintWriter printWriter = response.getWriter();

        // Recover the object cod 
        reserva.setCodigo(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = reservaDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (reserva.getCodigo() == arrayList.get(i).getCodigo()) {
                reserva.setCodCliente(arrayList.get(i).getCodCliente());
                reserva.setCodQuarto(arrayList.get(i).getCodQuarto());
                reserva.setDataCheckin(arrayList.get(i).getDataCheckin());
                reserva.setDataCheckout(arrayList.get(i).getDataCheckout());
                reserva.setQtdePessoa(arrayList.get(i).getQtdePessoa());
            }
        }

        // Send the response
        // for testes is the user email
        printWriter.println(reserva.getDataCheckin());
        
    }

}

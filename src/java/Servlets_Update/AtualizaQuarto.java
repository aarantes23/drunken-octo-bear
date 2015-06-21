/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Bean.Quarto;
import dao.QuartoDao;
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
public class AtualizaQuarto extends HttpServlet {
     
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
        Quarto quarto = new Quarto();
        QuartoDao quartoDao = new QuartoDao();
        PrintWriter printWriter = response.getWriter();

        // Fill the object with the data obtained
        quarto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        quarto.setAndar(request.getParameter("andar"));
        quarto.setTipo(request.getParameter("tipoQuarto"));
        quarto.setQuantAcom(request.getParameter("quantAcom"));

        // Print the response
        printWriter.println(quartoDao.update(quarto));
    }

}

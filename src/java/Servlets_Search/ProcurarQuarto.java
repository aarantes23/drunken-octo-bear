/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Bean.Quarto;
import dao.QuartoDao;
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
public class ProcurarQuarto extends HttpServlet {

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
        ArrayList<Quarto> arrayList = new ArrayList<Quarto>();
        PrintWriter printWriter = response.getWriter();

        // Recover the object cod 
        quarto.setCodigo(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = quartoDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (quarto.getCodigo() == arrayList.get(i).getCodigo()) {
                quarto.setAndar(arrayList.get(i).getAndar());
                quarto.setTipo(arrayList.get(i).getTipo());
                quarto.setQuantAcom(arrayList.get(i).getQuantAcom());
            }
        }

        // Send the response
        // for testes is the user email
        printWriter.println(quarto.getQuantAcom());

    }

}

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Bean.Consumo;
import dao.ConsumoDao;
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
public class ProcurarConsumo extends HttpServlet {

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
        Consumo consumo = new Consumo();
        ConsumoDao consumoDao = new ConsumoDao();
        ArrayList<Consumo> arrayList = new ArrayList<Consumo>();
        PrintWriter printWriter = response.getWriter();

        // Recover the object cod 
        consumo.setCodigo(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = consumoDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (consumo.getCodigo() == arrayList.get(i).getCodigo()) {
                consumo.setCodProd(arrayList.get(i).getCodProd());
                consumo.setCodClinte(arrayList.get(i).getCodClinte());
                consumo.setQuantidade(arrayList.get(i).getQuantidade());
                consumo.setValorTotal(arrayList.get(i).getValorTotal());
            }
        }

        // Send the response
        // for testes is the user email
        printWriter.println(consumo.getQuantidade());

    }

}

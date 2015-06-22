/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.CheckOut;
import dao.CheckOutDao;
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
public class SearchCheckOut extends HttpServlet {

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
        CheckOut checkOut = new CheckOut();
        CheckOutDao checkOutDao = new CheckOutDao();
        ArrayList<CheckOut> arrayList = new ArrayList<CheckOut>();

        // Recover the object cod
        checkOut.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = checkOutDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (checkOut.getId() == arrayList.get(i).getId()) {
                checkOut.setId(arrayList.get(i).getId());
                checkOut.setData(arrayList.get(i).getData());
            }
        }

        // Display de result in the java console
        System.out.println(checkOut.toString());

    }

}

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.CheckIn;
import dao.CheckInDao;
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
public class SearchCheckIn extends HttpServlet {

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
        CheckIn checkIn = new CheckIn();
        CheckInDao checkInDao = new CheckInDao();
        ArrayList<CheckIn> arrayList = new ArrayList<CheckIn>();
        boolean result = false;

        // Recover the object cod
        checkIn.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = checkInDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (checkIn.getId() == arrayList.get(i).getId()) {
                checkIn.setId(arrayList.get(i).getId());
                checkIn.setDate(arrayList.get(i).getDate());
                checkIn.setStatus(arrayList.get(i).getStatus());
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

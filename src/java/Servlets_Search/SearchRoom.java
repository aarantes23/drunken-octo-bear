/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.Room;
import dao.RoomDao;
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
public class SearchRoom extends HttpServlet {

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
        Room room = new Room();
        RoomDao roomDao = new RoomDao();
        ArrayList<Room> arrayList = new ArrayList<Room>();
        boolean result = false;

        // Recover the object cod
        room.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = roomDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (room.getId() == arrayList.get(i).getId()) {
                room.setId(arrayList.get(i).getId());
                room.setNumero(arrayList.get(i).getNumero());
                room.setAndar(arrayList.get(i).getAndar());
                room.setTipo(arrayList.get(i).getTipo());
                room.setValorDiaria(arrayList.get(i).getValorDiaria());
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

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

import Beans.Room;
import dao.RoomDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class CreateRoom extends HttpServlet {

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
        boolean result = false;

        // Fill the object with the data obtained
        room.setNumero(Integer.parseInt(request.getParameter("number")));        
        room.setAndar(request.getParameter("floor"));
        room.setTipo(request.getParameter("room_type"));
        room.setValorDiaria(Float.parseFloat(request.getParameter("daily_value")));                

        // Insert in the database  
        result = roomDao.insert(room);
        
        // Display de result
        if (result == true){
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
    }
}

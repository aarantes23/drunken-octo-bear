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

        // Fill the object with the data obtained
        room.setNumero(Integer.parseInt(request.getParameter("numero")));        
        room.setAndar(request.getParameter("andar"));
        room.setTipo(request.getParameter("tipo"));
        room.setValorDiaria(Float.parseFloat(request.getParameter("valorDiaria")));                

        // Insert in the database  
        String result = roomDao.insert(room);
        
        // Display de result in the java console
        System.out.println(result);
    }
}

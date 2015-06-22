/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Create;

import Beans.User;
import dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class CreateUser extends HttpServlet {

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
        User user = new User();
        UserDao userDao = new UserDao();
        boolean result = false;
        
        // Fill the object with the data obtained
        user.setName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setCpf(request.getParameter("cpf"));
        user.setPhone(request.getParameter("phone"));
        user.setAddress(request.getParameter("address"));
        user.setRg(request.getParameter("rg"));
        user.setSex(request.getParameter("sex"));
        user.setBirthday(request.getParameter("birthday"));                
        user.setUserType(Integer.parseInt(request.getParameter("userType")));        

        // Insert in the database
        result = userDao.insert(user);
        
        // Display de result
        if (result == true){
            response.sendRedirect("/config/operation_success");
        } else {
            response.sendRedirect("/config/operation_erro");
        }
    }
}

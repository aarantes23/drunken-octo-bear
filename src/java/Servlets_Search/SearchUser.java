/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.User;
import dao.UserDao;
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
public class SearchUser extends HttpServlet {

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
        ArrayList<User> arrayList = new ArrayList<User>();
        boolean result = false;

        // Recover the object cod
        user.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = userDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (user.getId() == arrayList.get(i).getId()) {
                user.setId(arrayList.get(i).getId());
                user.setName(arrayList.get(i).getName());
                user.setLogin(arrayList.get(i).getLogin());
                user.setPassword(arrayList.get(i).getPassword());
                user.setCpf(arrayList.get(i).getCpf());
                user.setPhone(arrayList.get(i).getPhone());
                user.setAddress(arrayList.get(i).getAddress());
                user.setRg(arrayList.get(i).getRg());
                user.setSex(arrayList.get(i).getSex());
                user.setBirthday(arrayList.get(i).getBirthday());
                user.setUserType(arrayList.get(i).getUserType());
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

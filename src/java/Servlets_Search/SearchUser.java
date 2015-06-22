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

        // Recover the object cod
        user.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = userDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (user.getId() == arrayList.get(i).getId()) {
                user.setId(arrayList.get(i).getId());
                user.setNome(arrayList.get(i).getNome());
                user.setLogin(arrayList.get(i).getLogin());
                user.setSenha(arrayList.get(i).getSenha());
                user.setCpf(arrayList.get(i).getCpf());
                user.setTelefone(arrayList.get(i).getTelefone());
                user.setEndereco(arrayList.get(i).getEndereco());
                user.setRg(arrayList.get(i).getRg());
                user.setSexo(arrayList.get(i).getSexo());
                user.setData_nascimento(arrayList.get(i).getData_nascimento());
                user.setUserType(arrayList.get(i).getUserType());
            }
        }

        // Display de result in the java console
        System.out.println(user.toString());
    }

}

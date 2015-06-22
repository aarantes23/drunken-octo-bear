/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

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
public class UpdateUser extends HttpServlet {

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

        // Fill the object with the data obtained
        user.setId(Integer.parseInt(request.getParameter("codigo")));
        user.setNome(request.getParameter("nome"));
        user.setLogin(request.getParameter("login"));
        user.setSenha(request.getParameter("senha"));
        user.setCpf(request.getParameter("cpf"));
        user.setTelefone(request.getParameter("telefone"));
        user.setEndereco(request.getParameter("endereco"));
        user.setRg(request.getParameter("rg"));
        user.setSexo(request.getParameter("sexo"));
        user.setData_nascimento(request.getParameter("data_nascimento"));
        user.setUserType(Integer.parseInt(request.getParameter("userType")));

        // Update in the database   
        userDao.update(user);

        // Display de result in the java console
        System.out.println(user.toString());
    }

}

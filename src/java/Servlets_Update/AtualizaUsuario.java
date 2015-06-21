/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Bean.Usuario;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class AtualizaUsuario extends HttpServlet {

    
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
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        PrintWriter printWriter = response.getWriter();

        // Fill the object with the data obtained
        usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setTipo(Integer.parseInt(request.getParameter("tipoAcesso")));

        // Print the response
        printWriter.println(usuarioDao.update(usuario));
    }
    
}

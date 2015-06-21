/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Bean.Usuario;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arthur
 */
public class ProcurarUsuario extends HttpServlet {

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
        ArrayList<Usuario> arrayList = new ArrayList<Usuario>();
        PrintWriter printWriter = response.getWriter();

        // Recover the object cod 
        usuario.setCodigo(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = usuarioDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (usuario.getCodigo() == arrayList.get(i).getCodigo()) {
                usuario.setEmail(arrayList.get(i).getEmail());
                usuario.setNome(arrayList.get(i).getNome());
                usuario.setTipo(arrayList.get(i).getTipo());
            }
        }

        // Send the response
        // for testes is the user email
        printWriter.println(usuario.getEmail());

    }
}

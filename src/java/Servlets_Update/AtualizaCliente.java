/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Bean.Cliente;
import dao.ClienteDao;
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
public class AtualizaCliente extends HttpServlet {
    
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
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        PrintWriter printWriter = response.getWriter();

        // Fill the object with the data obtained
        cliente.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        cliente.setNome(request.getParameter("nome"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setBairro(request.getParameter("bairro"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setNumero(request.getParameter("numero"));
        cliente.setCidade(request.getParameter("cidade"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setEmail(request.getParameter("email"));
        
        // Print the response
        printWriter.println(clienteDao.update(cliente));
    }
    
}

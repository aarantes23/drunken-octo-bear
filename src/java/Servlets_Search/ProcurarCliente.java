/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Bean.Cliente;
import dao.ClienteDao;
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
public class ProcurarCliente extends HttpServlet {

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
        ArrayList<Cliente> arrayList = new ArrayList<Cliente>();
        PrintWriter printWriter = response.getWriter();

        // Recover the object cod
        cliente.setCodigo(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = clienteDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (cliente.getCodigo() == arrayList.get(i).getCodigo()) {
                cliente.setNome(arrayList.get(i).getNome());
                cliente.setEndereco(arrayList.get(i).getEndereco());
                cliente.setBairro(arrayList.get(i).getBairro());
                cliente.setCep(arrayList.get(i).getCep());
                cliente.setNumero(arrayList.get(i).getNumero());
                cliente.setCidade(arrayList.get(i).getCidade());
                cliente.setTelefone(arrayList.get(i).getTelefone());
                cliente.setEmail(arrayList.get(i).getEmail());
            }
        }

        // Send the response
        // for testes is the user email
        printWriter.println(cliente.getEmail());
    }

}

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Update;

import Bean.Produto;
import dao.ProdutoDao;
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
public class AtualizaProduto extends HttpServlet {

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
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        PrintWriter printWriter = response.getWriter();

        // Fill the object with the data obtained
        produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        produto.setValor(Float.parseFloat(request.getParameter("valor")));
        produto.setDescricao(request.getParameter("descricao"));

        // Print the response
        printWriter.println(produtoDao.update(produto));
    }

}

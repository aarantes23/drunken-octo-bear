/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Bean.Produto;
import dao.ProdutoDao;
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
public class ProcurarProduto extends HttpServlet {

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
        ArrayList<Produto> arrayList = new ArrayList<Produto>();
        PrintWriter printWriter = response.getWriter();

        // Recover the object cod 
        produto.setCodigo(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db        
        arrayList = produtoDao.search();

        // Analyse the results        
        for (int i = 0; i < arrayList.size(); i++) {
            if (produto.getCodigo() == arrayList.get(i).getCodigo()) {
                produto.setDescricao(arrayList.get(i).getDescricao());               
                produto.setValor(arrayList.get(i).getValor());               
            }
        }

        // Send the response
        // for testes is the user email
        printWriter.println(produto.getDescricao());

    }

}

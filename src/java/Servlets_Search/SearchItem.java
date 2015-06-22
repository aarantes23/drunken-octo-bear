/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.Item;
import dao.ItemDao;
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
public class SearchItem extends HttpServlet {

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
        Item item = new Item();
        ItemDao itemDao = new ItemDao();
        ArrayList<Item> arrayList = new ArrayList<Item>();

        // Recover the object cod
        item.setId(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        arrayList = itemDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (item.getId() == arrayList.get(i).getId()) {
                item.setId(arrayList.get(i).getId());
                item.setValor(arrayList.get(i).getValor());
                item.setNome(arrayList.get(i).getNome());
            }
        }

        // Display de result in the java console
        System.out.println(item.toString());
    }

}

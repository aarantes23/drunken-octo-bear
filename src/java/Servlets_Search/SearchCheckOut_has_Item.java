/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Servlets_Search;

import Beans.CheckOut;
import Beans.CheckOut_has_Item;
import Beans.Item;
import dao.CheckOutDao;
import dao.CheckOut_has_Item_Dao;
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
public class SearchCheckOut_has_Item extends HttpServlet {

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

        // Teste
        String result = "false";

        // Objects used 
        CheckOut checkOut = new CheckOut();
        Item item = new Item();
        CheckOut_has_Item checkOut_has_Item = new CheckOut_has_Item();

        // Dao Class's
        CheckOutDao checkOutDao = new CheckOutDao();
        ItemDao itemDao = new ItemDao();
        CheckOut_has_Item_Dao checkOut_has_ItemDao = new CheckOut_has_Item_Dao();

        // Arrays list for search
        ArrayList<CheckOut> checkOut_List = new ArrayList<CheckOut>();
        ArrayList<Item> search_item_List = new ArrayList<Item>();
        ArrayList<Item> consumed_item_List = new ArrayList<Item>();
        ArrayList<CheckOut_has_Item> checkOut_has_Items_List = new ArrayList<CheckOut_has_Item>();

        // Recover the object cod
        checkOut_has_Item.setCheck_out_id(Integer.parseInt(request.getParameter("codigoBuscar")));

        // Search in the db
        checkOut_List = checkOutDao.search();
        search_item_List = itemDao.search();
        checkOut_has_Items_List = checkOut_has_ItemDao.search();

        // Analyse the results
        // in search of the consume item`s by checkOut`s id
        for (int i = 0; i < checkOut_has_Items_List.size(); i++) {
            if (checkOut_has_Item.getCheck_out_id() == checkOut_has_Items_List.get(i).getCheck_out_id()) {
                for (int j = 0; j < search_item_List.size(); j++) {
                    if (checkOut_has_Items_List.get(i).getItem_id() == search_item_List.get(j).getId()) {
                        Item item_temp = new Item();
                        item_temp.setId(search_item_List.get(j).getId());
                        item_temp.setNome(search_item_List.get(j).getNome());
                        item_temp.setValor(search_item_List.get(j).getValor());
                        consumed_item_List.add(item_temp);
                        result = "ok";
                    }
                }
            }
        }

        // Send the response
        // consumed_item_List;
        // Display de result in the java console
        System.out.println(result);
    }

}

<%-- 
    Document   : add_item
    Created on : 26-Jun-2015, 11:21:00
    Author     : Arthur
--%>

<%@page import="dao.CheckOut_has_Item_Dao"%>
<%@page import="Beans.CheckOut_has_Item"%>
<%@page import="dao.CheckOutDao"%>
<%@page import="dao.CheckOutDao"%>
<%@page import="Beans.CheckOut"%>
<%@page import="Beans.CheckOut"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ReservationDao"%>
<%@page import="Beans.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            // Search the reservation
            // Objects used
            Reservation reservation = new Reservation();
            ReservationDao reservationDao = new ReservationDao();
            ArrayList<Reservation> arrayList = new ArrayList<Reservation>();
            arrayList = reservationDao.search();
            boolean result = false;

            // Recover the object cod 
            reservation.setId(Integer.parseInt(request.getParameter("reservation_id")));

            // Analyse the results        
            for (int i = 0; i < arrayList.size(); i++) {
                if (reservation.getId() == arrayList.get(i).getId()) {
                    reservation.setId(arrayList.get(i).getId());
                    reservation.setRoom_id(arrayList.get(i).getRoom_id());
                    reservation.setClient_id(arrayList.get(i).getClient_id());
                    reservation.setUser_id(arrayList.get(i).getUser_id());
                    reservation.setCheck_out_id(arrayList.get(i).getCheck_out_id());
                    reservation.setCheck_in_id(arrayList.get(i).getCheck_in_id());
                    result = true;
                }
            }

            if (result == true) {
                // Search the checkOut from the reservation
                // Objects used 
                CheckOut checkOut = new CheckOut();
                CheckOutDao checkOutDao = new CheckOutDao();
                ArrayList<CheckOut> arrayListCheckOut = new ArrayList<CheckOut>();

                // Recover the object cod
                checkOut.setId(reservation.getCheck_out_id());

                // Search in the db
                arrayListCheckOut = checkOutDao.search();

                // Analyse the results
                for (int i = 0; i < arrayListCheckOut.size(); i++) {
                    if (checkOut.getId() == arrayListCheckOut.get(i).getId()) {
                        checkOut.setId(arrayListCheckOut.get(i).getId());

                        // Objects used
                        CheckOut_has_Item checkOut_has_Item = new CheckOut_has_Item();
                        CheckOut_has_Item_Dao checkOut_has_Item_Dao = new CheckOut_has_Item_Dao();
                        boolean resultCheckOut_has_Item = false;

                        // Fill the object with the data obtained
                        checkOut_has_Item.setCheck_out_id(checkOut.getId());
                        checkOut_has_Item.setItem_id(Integer.parseInt(request.getParameter("item_id")));

                        // Insert in the database   
                        resultCheckOut_has_Item = checkOut_has_Item_Dao.insert(checkOut_has_Item);

                        // Display de result
                        if (resultCheckOut_has_Item == true) {
                            response.sendRedirect("/web_system_hotel_1/loopings/looping_add_item.jsp");
                        } else {
                            response.sendRedirect("/web_system_hotel_1/config/operation_erro.jsp");
                        }
                    }
                }

            } else {
                response.sendRedirect("/web_system_hotel_1/Login/index_after_login.jsp");
            }

        %>
    </body>
</html>

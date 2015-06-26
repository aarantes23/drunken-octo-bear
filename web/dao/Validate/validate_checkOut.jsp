<%-- 
    Document   : validate_checkOut
    Created on : 26-Jun-2015, 11:09:14
    Author     : Arthur
--%>

<%@page import="dao.CheckOutDao"%>
<%@page import="Beans.CheckOut"%>
<%@page import="dao.CheckInDao"%>
<%@page import="Beans.CheckIn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ReservationDao"%>
<%@page import="Beans.Reservation"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            // Get today`s date
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

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

            // If the reservation exist
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
                        checkOut.setDate(dateFormat.format(date));
                        checkOut.setStatus(0);
                        // Update checkIn the database   
                        checkOutDao.update(checkOut);
                    }
                }
                response.sendRedirect("/web_system_hotel_1/dao/Add/add_item.jsp");
            } else {
                response.sendRedirect("/web_system_hotel_1/config/operation_erro.jsp");
            }

        %>
    </body>
</html>

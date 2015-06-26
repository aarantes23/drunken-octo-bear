<%-- 
    Document   : validade_checkIn
    Created on : 23-Jun-2015, 11:44:32
    Author     : Arthur
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="dao.CheckInDao"%>
<%@page import="Beans.CheckIn"%>
<%@page import="dao.ReservationDao"%>
<%@page import="Beans.Reservation"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip hotel - Validate</title>
    </head>
    <%
        // Get today`s date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
            // Search the checkIn from the reservation
            // Objects used 
            CheckIn checkIn = new CheckIn();
            CheckInDao checkInDao = new CheckInDao();
            ArrayList<CheckIn> arrayListCheckIn = new ArrayList<CheckIn>();

            // Recover the object cod
            checkIn.setId(reservation.getCheck_in_id());

            // Search in the db
            arrayListCheckIn = checkInDao.search();

            // Analyse the results
            for (int i = 0; i < arrayListCheckIn.size(); i++) {
                if (checkIn.getId() == arrayListCheckIn.get(i).getId()) {
                    checkIn.setId(arrayListCheckIn.get(i).getId());
                    checkIn.setDate(dateFormat.format(date));
                    checkIn.setStatus(0);
                    // Update checkIn the database   
                    checkInDao.update(checkIn);

                }
            }
            response.sendRedirect("/web_system_hotel_1/config/operation_success.jsp");
        } else {
            response.sendRedirect("/web_system_hotel_1/config/operation_erro.jsp");
        }

    %>
</html>

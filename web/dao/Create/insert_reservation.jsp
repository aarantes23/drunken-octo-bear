<%-- 
    Document   : insert_reservation
    Created on : 23-Jun-2015, 11:44:32
    Author     : Arthur
--%>

<%@page import="dao.ReservationDao"%>
<%@page import="Beans.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip hotel - Insert</title>
    </head>
    <body>                
        <%
            Reservation reservation = new Reservation();
            ReservationDao reservationDao = new ReservationDao();
            
            String room_id = request.getParameter("room_id");
            String client_id = request.getParameter("client_id");
            String user_id = request.getParameter("user_id");
            String check_out_id = request.getParameter("check_out_id");
            String check_in_id = request.getParameter("check_in_id");
            
            reservation.setRoom_id(Integer.parseInt(room_id));
            reservation.setClient_id(Integer.parseInt(client_id));
            reservation.setUser_id(Integer.parseInt(user_id));
            reservation.setCheck_out_id(Integer.parseInt(check_out_id));
            reservation.setCheck_in_id(Integer.parseInt(check_in_id));
            
            reservationDao.insert(reservation);                        
        %>
               

    </body>
</html>

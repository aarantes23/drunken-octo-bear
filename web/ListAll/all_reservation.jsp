<%-- 
    Document   : create_reservation
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - All Reservation</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">   
                        <h3>All Reservations</h3>
                        <jsp:useBean id="reservationDao" class="dao.ReservationDao"/>
                        <jsp:useBean id="reservation" class="Beans.Reservation"/>                        
                        <c:set var="list_reservation" value="${reservationDao.search()}" scope="page"/>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        Id
                                    </th>
                                    <th>
                                        Room id
                                    </th>
                                    <th>
                                        Client id
                                    </th>
                                     <th>
                                        User id
                                    </th>
                                    <th>
                                        Check out id
                                    </th>
                                    <th>
                                        Check in id
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="new_reservation" items="${list_reservation}">
                                <tr>
                                    <th>
                                        ${new_reservation.id}
                                    </th>
                                    <th>
                                        ${new_reservation.room_id}
                                    </th>
                                    <th>
                                        ${new_reservation.client_id}
                                    </th> 
                                    <th>
                                        ${new_reservation.user_id}
                                    </th>
                                    <th>
                                        ${new_reservation.check_out_id}
                                    </th>
                                    <th>
                                        ${new_reservation.check_in_id}
                                    </th> 
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
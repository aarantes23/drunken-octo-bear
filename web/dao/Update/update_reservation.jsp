<%-- 
    Document   : update_reservation
    Created on : 23-Jun-2015, 11:44:32
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip hotel - Update</title>
    </head>
    <body>        
        <jsp:useBean id="reservation" class="Beans.Reservation"/>
        <jsp:useBean id="reservationDao" class="dao.ReservationDao"/>
                
        ${reservation.setsetId(param.code)}
        ${reservation.setClient_id(param.client_id)}
        ${reservation.setUser_id(param.user_id)}
        ${reservation.setCheck_out_id(param.check_out_id)}
        ${reservation.setCheck_in_id(param.check_in_id)}

        <c:if test="${reservationDao.update(reservation)}">
            <c:redirect url="/config/operation_success.jsp"/>
        </c:if>
        <c:redirect url="/config/operation_erro.jsp"/>

    </body>
</html>

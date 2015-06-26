<%-- 
    Document   : update_room
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
        <jsp:useBean id="room" class="Beans.Room"/>
        <jsp:useBean id="roomDao" class="dao.RoomDao"/>
        
        ${room.setId(param.code)}
        ${room.setNumber(param.number)}
        ${room.setFloor(param.floor)}
        ${room.setType(param.room_type)}
        ${room.setDaily_value(param.daily_value)}
        

        <c:if test="${roomDao.update(room)}">
            <c:redirect url="/config/operation_success.jsp"/>
        </c:if>
        <c:redirect url="/config/operation_erro.jsp"/>

    </body>
</html>

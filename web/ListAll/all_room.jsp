<%-- 
    Document   : create_room
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Make Room</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">   
                        <h3>All Rooms</h3>
                        <jsp:useBean id="roomDao" class="dao.RoomDao"/>
                        <jsp:useBean id="room" class="Beans.Room"/>                        
                        <c:set var="list_room" value="${roomDao.search()}" scope="page"/>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        Id
                                    </th>
                                    <th>
                                        Number
                                    </th>
                                    <th>
                                        Floor
                                    </th>
                                    <th>
                                        Type
                                    </th>
                                    <th>
                                        Daily value
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="new_room" items="${list_room}">
                                <tr>
                                    <th>
                                        ${new_room.id}
                                    </th>
                                    <th>
                                        ${new_room.number}
                                    </th>
                                    <th>
                                        ${new_room.floor}
                                    </th>  
                                    <th>
                                        ${new_room.type}
                                    </th>
                                    <th>
                                        ${new_room.daily_value}
                                    </th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
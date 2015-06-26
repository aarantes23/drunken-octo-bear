<%-- 
    Document   : create_room
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create new room</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Create New Room</h3>
                        <form action="../dao/Create/insert_room.jsp" method="post">
                            <p>Number : <input name="number" type="number" id="number" required="true"</p>
                            <p>Floor : <input name="floor" type="number" id="floor" required="true"</p>                            
                            <p>Daily value : <input name="daily_value" type="number" id="daily_value" required="true"</p>
                            <p>Room type :  
                                <select name="room_type" id="room_type">
                                    <option value="1">Single</option>
                                    <option value="2">Couple</option>
                                </select>
                            </p>    
                            <p><input type="submit" value="Create"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
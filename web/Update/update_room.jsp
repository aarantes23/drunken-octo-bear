<%-- 
    Document   : update_room
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Room</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Room</h3>
                        <form action="../dao/Update/update_room.jsp" method="post">
                            <p>Code : <input name="code" type="number" id="code" required="true"</p>                            
                            <p>New Number : <input name="number" type="number" id="number"</p>
                            <p>New Floor : <input name="floor" type="number" id="floor"</p>                            
                            <p>New Daily value : <input name="daily_value" type="number" id="daily_value" required="true"</p>
                            <p>Room type :  
                                <select name="tipo" id="room_type">
                                    <option value="1">Single</option>
                                    <option value="2">Couple</option>
                                </select>
                            </p>    
                            <p><input type="submit" value="Update"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>

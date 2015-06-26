<%-- 
    Document   : update_reservation
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Reservation</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Reservation</h3>
                        <form action="../dao/Update/update_reservation.jsp" method="post">
                            <p>Code : <input name="code" type="number" id="code" required="true"</p>                            
                            <p>New Check in Date: <input name="check_in_date" type="number" id="check_in_date" required="true"</p>                                                    
                            <p>New Room code : <input name="room_id" type="number" id="room_id" required="true"</p>                        
                            <p>New Client code : <input name="client_id" type="number" id="client_id" required="true"</p>
                            <p>New User Responsible code : <input name="user_id" type="number" id="user_id" required="true"</p>
                            <p>New Check out code : <input name="check_out_id" type="number" id="check_out_id" required="true"</p>                        
                            <p><input type="submit" value="Update"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
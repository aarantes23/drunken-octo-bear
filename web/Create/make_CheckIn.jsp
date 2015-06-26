<%-- 
    Document   : create_checkIn
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Make CheckIn</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">                        
                        <h3>Make CheckIn</h3>
                        <form  method="post" action="../dao/Validate/validade_checkIn.jsp">                           
                            <p>Reservation id : <input type="number" id="reservation_id" required="true" name="reservation_id"></p>                            
                            <p><input type="submit" value="Create"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
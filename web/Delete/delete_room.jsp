<%-- 
    Document   : delete_room
    Created on : 21-Jun-2015, 17:00:23
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Delete Room</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Delete Room</h3>
                        <form action="../Delete/delete_room.jsp" method="post">
                            <p>Room code : <input name="code" type="number" id="code" required="true"</p>                        
                            <p><input type="submit" value="Delete"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>